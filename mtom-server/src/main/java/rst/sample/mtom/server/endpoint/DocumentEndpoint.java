package rst.sample.mtom.server.endpoint;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import rst.sample.mtom.jaxb.Document;
import rst.sample.mtom.jaxb.StoreDocumentRequest;
import rst.sample.mtom.jaxb.StoreDocumentResponse;

@Endpoint
public class DocumentEndpoint {

	private static final String NAMESPACE_URI = "https://github.com/ralfstuckert/mtom";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "storeDocumentRequest")
	@ResponsePayload
	public StoreDocumentResponse storeDocument(@RequestPayload StoreDocumentRequest request) throws IOException {
		Document document = request.getDocument();
		try (InputStream in = document.getContent().getInputStream()) {
			storeFile(in);
			long counter = 0;
			while (in.read() != -1) {
				++counter;
			}
			System.out.println(String.format("received %d bytes", counter));
		}
		StoreDocumentResponse response = new StoreDocumentResponse();
		response.setSuccess(true);
		return response;
	}

	private void storeFile(InputStream in) throws IOException {
		String filePath = "c:\\temp\\"+new Date().getTime()+".pdf";
		File file = new File(filePath);
		copyInputStreamToFile(in, file);
	}

	// InputStream -> File
	private static void copyInputStreamToFile(InputStream inputStream, File file) throws IOException {

		try (FileOutputStream outputStream = new FileOutputStream(file)) {

			int read;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		}

	}
}
