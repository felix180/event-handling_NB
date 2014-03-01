package coreservlets;

import java.io.*;
import java.util.*;
import javax.faces.bean.*;
import javax.faces.event.*;

@ManagedBean
@SessionScoped
public class FormSettings implements Serializable {
  private static final long serialVersionUID = 1L;
  private boolean isNormalSize = true;
  private boolean isEnglish = true;
  private static final Locale ENGLISH = new Locale("en");
  private static final Locale SPANISH = new Locale("es");
  private Locale locale = ENGLISH;
  private String language = "en";
  private static final Map<String,String> LANGUAGE_MAP = 
    new LinkedHashMap<>(); 
  
  static {
    LANGUAGE_MAP.put("English", "en");
    LANGUAGE_MAP.put("Español", "es");
    LANGUAGE_MAP.put("日本人", "jp");
  }
  
  public String getBodyStyleClass() {
    if (isNormalSize) {
      return("normalSize");
    } else {
      return("largeSize");
    }
  }
  
  public void setNormalSize(ActionEvent event) {
    isNormalSize = true;
  }
  
  public void setLargeSize(ActionEvent event) {
    isNormalSize = false;
  }
  
  public Locale getLocale() {
    return(locale);
  }
  
  public void swapLocale(ActionEvent event) {
    isEnglish = !isEnglish;
    if (isEnglish) {
      locale = ENGLISH;
    } else {
      locale = SPANISH;
    }
  }

  public String getLanguage() {
    return(language);
  }

  public void setLanguage(String language) {
    this.language = language;
    locale = new Locale(language);
  }

  public Map<String,String> getLanguages() {
    return(LANGUAGE_MAP);
  }
}
