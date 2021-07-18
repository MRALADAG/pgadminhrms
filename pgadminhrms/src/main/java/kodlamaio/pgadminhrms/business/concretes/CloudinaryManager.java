package kodlamaio.pgadminhrms.business.concretes;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.pgadminhrms.business.abstracts.CloudinaryService;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.core.utilities.results.ErrorDataResult;
import kodlamaio.pgadminhrms.core.utilities.results.SuccessDataResult;

public class CloudinaryManager implements CloudinaryService {

	private Cloudinary cloudinary;

	@Autowired
	public CloudinaryManager(Cloudinary cloudinary) {

		this.cloudinary = cloudinary;

	}

	@Override
	public DataResult<?> save(MultipartFile file) {

		try {

			Map cloudinaryUploadImage = this.cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(cloudinaryUploadImage);

		} catch (IOException e) {

			e.printStackTrace();

		}

		return new ErrorDataResult<Map>();

	}

}
