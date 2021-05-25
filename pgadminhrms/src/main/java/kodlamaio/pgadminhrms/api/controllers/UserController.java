package kodlamaio.pgadminhrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.pgadminhrms.business.abstracts.UserService;
import kodlamaio.pgadminhrms.core.utilities.results.DataResult;
import kodlamaio.pgadminhrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UserController {

	// Controller sınıfları API de dış dünya ile sistemimizin iletişim kurduğu
	// yerdir. Ayrıca sistemin başka sistemlerle uyumlu bir şekilde çelışmesını
	// sağlar.
	// Örneğin dış dünyadan bize //kodlama.io/api/users isteği gelirse bu isteği
	// UsersController sınıfı karşılayacak demektir.
	// Api katmanının Business ile iletişim kurması gereklidir.

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
		// Burada @Autowired anotasyonu arka planda UserService interface'ini implemente
		// eden UserManager sınıfını new'leme görevini üstleniyor.
	}

	@GetMapping("/getall")
	// Bu anotasyon http veri isteğine (http get) karşılık geliyor.

	public DataResult<List<User>> getAll() {

		// ("/getall") Bu ifade; eğer bir kişi kodlama.io/api/users/getall şeklinde bir
		// istekte bulunursa bu metodu çalıştır demektir.
		// Bu controller'lar ileride multiple fronthand kodlamalarında kullanılabilir.
		return this.userService.getAll();

	}
}
