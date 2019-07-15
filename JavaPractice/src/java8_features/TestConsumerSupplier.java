package java8_features;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class TestConsumerSupplier {

	public static void main(String[] args) {
		Consumer<String> con = str -> System.out.println(str);
		con.accept("hello");
		con.accept("poonam");
		Supplier<String> sup = () -> {
			String otpNum = "";
			for (int i = 0; i < 6; i++) {
				otpNum += (int) (Math.random() * 10);
			}
			return otpNum;
		};
		System.out.println(sup.get());

	}

}
