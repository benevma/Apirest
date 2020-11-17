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
 * Main lemma info
 */
public class MainLemma {
  private String value = null;

  private Float score = null;

  private List<DocumentPosition> positions = null;

  public MainLemma value(String value) {
    this.value = value;
    return this;
  }

   /**
   * Lemma
   * @return value
  **/
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public MainLemma score(Float score) {
    this.score = score;
    return this;
  }

   /**
   * Score assigned to the lemma to represent its relevance
   * @return score
  **/
  public Float getScore() {
    return score;
  }

  public void setScore(Float score) {
    this.score = score;
  }

  public MainLemma positions(List<DocumentPosition> positions) {
    this.positions = positions;
    return this;
  }

  public MainLemma addPositionsItem(DocumentPosition positionsItem) {
    if (this.positions == null) {
      this.positions = new ArrayList<DocumentPosition>();
    }
    this.positions.add(positionsItem);
    return this;
  }

   /**
   * Positions of lemma occurrences
   * @return positions
  **/
  public List<DocumentPosition> getPositions() {
    return positions;
  }

  public void setPositions(List<DocumentPosition> positions) {
    this.positions = positions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MainLemma mainLemma = (MainLemma) o;
    return Objects.equals(this.value, mainLemma.value) &&
        Objects.equals(this.score, mainLemma.score) &&
        Objects.equals(this.positions, mainLemma.positions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, score, positions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MainLemma {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
    sb.append("    positions: ").append(toIndentedString(positions)).append("\n");
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
