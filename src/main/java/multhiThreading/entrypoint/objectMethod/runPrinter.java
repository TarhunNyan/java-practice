package multhiThreading.entrypoint.objectMethod;

import java.util.Map;
import java.util.Objects;

public class runPrinter {
	
	public static void main(String[] args) {
		var obj = "Petia";
		String test = Objects.requireNonNullElse(obj, "Vasia");
		System.out.println(test );
		//        Designer tanya = new Designer();
		//        Design simpleDesign = new Design(tanya, "Простой дизайн");
		//        Storage storage = new Storage();
		//        Printer printer = new Printer(2, 3, "epson-4250", storage);
		//        printer.print(simpleDesign);
		//        printer.print(simpleDesign);
		//        printer.print(simpleDesign);
		
	}
}
