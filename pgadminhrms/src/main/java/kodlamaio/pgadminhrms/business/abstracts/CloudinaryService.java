package kodlamaio.pgadminhrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.pgadminhrms.core.utilities.results.DataResult;

public interface CloudinaryService {

	DataResult<?> save(MultipartFile file);

}
