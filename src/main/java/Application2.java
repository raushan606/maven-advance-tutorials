import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Application2 {

	 public static void main(String[] args) {
	        File warFile = new File("C:\\Users\\Raushan\\AppData\\Local\\Temp\\upload14595835763614862007.war");

	        try (JarFile jarFile = new JarFile(warFile)) {
	            Enumeration<JarEntry> entries = jarFile.entries();

	            while (entries.hasMoreElements()) {
	                JarEntry entry = entries.nextElement();
	                String entryName = entry.getName();

	                if (entryName.endsWith(".class")) {
	                    String className = entryName.replace("/", ".").substring(0, entryName.length() - 6);

	                    try (FileInputStream fis = new FileInputStream(new File(warFile, entryName))) {
	                        // Read the class file content
	                        byte[] classBytes = new byte[(int) entry.getSize()];
	                        fis.read(classBytes);

	                        // Analyze the class as needed
	                        analyzeClass(className, classBytes);
	                    }
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static void analyzeClass(String className, byte[] classBytes) {
	        // Perform the necessary analysis of the class
	        // You can use tools like ASM or reflection to inspect the class structure,
	        // retrieve the imports, and determine the Jakarta EE version.
	        // Example code:
	        System.out.println("Class: " + className);
	        System.out.println("Imports:");
	        // TODO: Analyze the class and print the imports
	    }

}
