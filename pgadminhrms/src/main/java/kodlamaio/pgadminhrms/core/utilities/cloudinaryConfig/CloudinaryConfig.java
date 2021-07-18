package kodlamaio.pgadminhrms.core.utilities.cloudinaryConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.pgadminhrms.business.abstracts.CloudinaryService;
import kodlamaio.pgadminhrms.business.concretes.CloudinaryManager;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;

@Configuration
public class CloudinaryConfig {

	@Value("${cld.access-key}")
	String apiKey;

	@Value("${cld.secret-key}")
	String apiSecretKey;

	@Bean
	public Cloudinary cloudinaryUser() {

		return new Cloudinary(
				ObjectUtils.asMap(
						
						"cloud_name", "dr26p8jgb", 
						"api_key", apiKey, 
						"api_secret", apiSecretKey
						
						)
				);

	}

	@Bean
	public CloudinaryService cloudinaryService() {

		return new CloudinaryManager(cloudinaryUser());

	}

}
