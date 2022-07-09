package pe.systems.shop.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public class FacesUtils {

  public static final int ERROR = 1;
  public static final int INFO = 2;
	public static final int WARN = 3;
	
	
	
	
	  public static void execute(String script) {
	        RequestContext.getCurrentInstance().execute(script);
	    }

  public static void showMessage(String message, int icon) {
    switch (icon) {
      case ERROR:
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
        break;
      case INFO:
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        break;
      case WARN:
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, message, message));
        break;
    }
  }
 
  
  public static void createFile(byte[] bytes, String urlFile) {
    if (bytes != null) {
      FileOutputStream fos;
      try {
        fos = new FileOutputStream(urlFile);
        fos.write(bytes);
        fos.close();
      } catch (IOException e) {
        System.out.println("Error al crear Archivo: " + e.getMessage());
      }
    } else {
      System.out.println("Error al crear Archivo: El archivo enviado es NULL");
    }
  }

  public static byte[] uploadFile(String urlFile) {
    byte[] bytes = null;
    try {
      Path path = Paths.get(urlFile);
      bytes = Files.readAllBytes(path);
    } catch (IOException ex) {
      System.out.println("Error al cargar archivo");
    }
    return bytes;
  }

  public static void deleteFile(String url) {
    File file = new File(url);
    if (file.exists()) {
      file.delete();
      System.out.println("El archivo " + url + " se elimino correctamente.");
    } else {
      System.out.println("El archivo " + url + " no existe.");
    }
  }
}
