package ie.cct.customhttp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedExeption extends RuntimeException {

	public UnauthorizedExeption() {
		// TODO Auto-generated constructor stub
	}

	public UnauthorizedExeption(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public UnauthorizedExeption(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public UnauthorizedExeption(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public UnauthorizedExeption(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
