package ra.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import io.grpc.Context;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration

public class FirebaseConfig {
    private final String serviceAccountKeyPath = "C:\\Users\\USER\\Desktop\\TOCAT\\project4\\src\\main\\webapp\\resouces\\firebaseConfig.json";

    @Bean
    public Storage storage() throws IOException {
        InputStream serviceAccount = Files.newInputStream(Paths.get(serviceAccountKeyPath));
        return StorageOptions.newBuilder().setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build().getService();
    }
}
