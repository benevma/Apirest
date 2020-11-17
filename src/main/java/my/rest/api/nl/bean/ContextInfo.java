/*
 * expert.ai Natural Language API
 * Natural Language API provides a comprehensive set of natural language understanding capabilities based on expert.ai technology: <ul>   <li>Text subdivision</li>   <li>Part-of-speech tagging</li>   <li>Syntactic analysis</li>   <li>Lemmatization</li>   <li>Keyphrase extraction</li>   <li>Semantic analysis</li>   <li>Named entity recognition</li>   <li>Relation extraction</li>   <li>Sentiment analysis</li>   <li>Classification</li> </ul> 
 *
 * OpenAPI spec version: v2
 * Contact: api.inquiry@expert.ai
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package my.rest.api.nl.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Information about a context
 */
public class ContextInfo {

  private String name = null;


  private String description = null;


  private List<ContextLanguageInfo> languages = null;

  public ContextInfo name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Context name
   * @return name
  **/

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ContextInfo description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Context description
   * @return description
  **/

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ContextInfo languages(List<ContextLanguageInfo> languages) {
    this.languages = languages;
    return this;
  }

  public ContextInfo addLanguagesItem(ContextLanguageInfo languagesItem) {
    if (this.languages == null) {
      this.languages = new ArrayList<ContextLanguageInfo>();
    }
    this.languages.add(languagesItem);
    return this;
  }

   /**
   * Information about supported languages and available analyses
   * @return languages
  **/

  public List<ContextLanguageInfo> getLanguages() {
    return languages;
  }

  public void setLanguages(List<ContextLanguageInfo> languages) {
    this.languages = languages;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContextInfo contextInfo = (ContextInfo) o;
    return Objects.equals(this.name, contextInfo.name) &&
        Objects.equals(this.description, contextInfo.description) &&
        Objects.equals(this.languages, contextInfo.languages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, languages);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContextInfo {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    languages: ").append(toIndentedString(languages)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
