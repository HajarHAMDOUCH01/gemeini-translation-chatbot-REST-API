package rest.project.jakarta.hello;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class TranslateApplication extends Application {
  // Needed to enable Jakarta REST and specify path.    
}
