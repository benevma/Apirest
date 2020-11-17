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
 * Token info
 */
public class Token {
  private Long start = null;

  private Long end = null;

  private String type = null;

  private String pos = null;

  private String lemma = null;

  private Long syncon = null;

  private String morphology = null;

  private Dependency dependency = null;

  private List<Atom> atoms = null;

  private Long paragraph = null;

  private Long sentence = null;

  private Long phrase = null;

  public Token start(Long start) {
    this.start = start;
    return this;
  }

   /**
   * Zero-based position of the first character of the token
   * @return start
  **/
  public Long getStart() {
    return start;
  }

  public void setStart(Long start) {
    this.start = start;
  }

  public Token end(Long end) {
    this.end = end;
    return this;
  }

   /**
   * Zero-based position of the first character after the token
   * @return end
  **/
  public Long getEnd() {
    return end;
  }

  public void setEnd(Long end) {
    this.end = end;
  }

  public Token type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Cogito type
   * @return type
  **/
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Token pos(String pos) {
    this.pos = pos;
    return this;
  }

   /**
   * &lt;a href&#x3D;&#x27;https://universaldependencies.org/u/pos/&#x27;&gt;Universal Dependencies part-of-speech tag&lt;/a&gt;
   * @return pos
  **/
  public String getPos() {
    return pos;
  }

  public void setPos(String pos) {
    this.pos = pos;
  }

  public Token lemma(String lemma) {
    this.lemma = lemma;
    return this;
  }

   /**
   * Lemma
   * @return lemma
  **/
  public String getLemma() {
    return lemma;
  }

  public void setLemma(String lemma) {
    this.lemma = lemma;
  }

  public Token syncon(Long syncon) {
    this.syncon = syncon;
    return this;
  }

   /**
   * ID used to look up Knowledge Graph data in the &#x60;knowledge&#x60; array
   * @return syncon
  **/
  public Long getSyncon() {
    return syncon;
  }

  public void setSyncon(Long syncon) {
    this.syncon = syncon;
  }

  public Token morphology(String morphology) {
    this.morphology = morphology;
    return this;
  }

   /**
   * A semicolon separated list of &lt;a href&#x3D;&#x27;https://universaldependencies.org/format.html#morphological-annotation&#x27;&gt;CoNLL-U format&lt;/a&gt; morphological features
   * @return morphology
  **/
  public String getMorphology() {
    return morphology;
  }

  public void setMorphology(String morphology) {
    this.morphology = morphology;
  }

  public Token dependency(Dependency dependency) {
    this.dependency = dependency;
    return this;
  }

   /**
   * Get dependency
   * @return dependency
  **/
  public Dependency getDependency() {
    return dependency;
  }

  public void setDependency(Dependency dependency) {
    this.dependency = dependency;
  }

  public Token atoms(List<Atom> atoms) {
    this.atoms = atoms;
    return this;
  }

  public Token addAtomsItem(Atom atomsItem) {
    if (this.atoms == null) {
      this.atoms = new ArrayList<Atom>();
    }
    this.atoms.add(atomsItem);
    return this;
  }

   /**
   * Atoms that make up the token
   * @return atoms
  **/
  public List<Atom> getAtoms() {
    return atoms;
  }

  public void setAtoms(List<Atom> atoms) {
    this.atoms = atoms;
  }

  public Token paragraph(Long paragraph) {
    this.paragraph = paragraph;
    return this;
  }

   /**
   * Paragraph index in the &#x60;paragraphs&#x60; array
   * @return paragraph
  **/
  public Long getParagraph() {
    return paragraph;
  }

  public void setParagraph(Long paragraph) {
    this.paragraph = paragraph;
  }

  public Token sentence(Long sentence) {
    this.sentence = sentence;
    return this;
  }

   /**
   * Sentence index in the &#x60;sentences&#x60; array
   * @return sentence
  **/
  public Long getSentence() {
    return sentence;
  }

  public void setSentence(Long sentence) {
    this.sentence = sentence;
  }

  public Token phrase(Long phrase) {
    this.phrase = phrase;
    return this;
  }

   /**
   * Phrase index in the &#x60;phrases&#x60; array
   * @return phrase
  **/
   public Long getPhrase() {
    return phrase;
  }

  public void setPhrase(Long phrase) {
    this.phrase = phrase;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Token token = (Token) o;
    return Objects.equals(this.start, token.start) &&
        Objects.equals(this.end, token.end) &&
        Objects.equals(this.type, token.type) &&
        Objects.equals(this.pos, token.pos) &&
        Objects.equals(this.lemma, token.lemma) &&
        Objects.equals(this.syncon, token.syncon) &&
        Objects.equals(this.morphology, token.morphology) &&
        Objects.equals(this.dependency, token.dependency) &&
        Objects.equals(this.atoms, token.atoms) &&
        Objects.equals(this.paragraph, token.paragraph) &&
        Objects.equals(this.sentence, token.sentence) &&
        Objects.equals(this.phrase, token.phrase);
  }

  @Override
  public int hashCode() {
    return Objects.hash(start, end, type, pos, lemma, syncon, morphology, dependency, atoms, paragraph, sentence, phrase);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Token {\n");
    
    sb.append("    start: ").append(toIndentedString(start)).append("\n");
    sb.append("    end: ").append(toIndentedString(end)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    pos: ").append(toIndentedString(pos)).append("\n");
    sb.append("    lemma: ").append(toIndentedString(lemma)).append("\n");
    sb.append("    syncon: ").append(toIndentedString(syncon)).append("\n");
    sb.append("    morphology: ").append(toIndentedString(morphology)).append("\n");
    sb.append("    dependency: ").append(toIndentedString(dependency)).append("\n");
    sb.append("    atoms: ").append(toIndentedString(atoms)).append("\n");
    sb.append("    paragraph: ").append(toIndentedString(paragraph)).append("\n");
    sb.append("    sentence: ").append(toIndentedString(sentence)).append("\n");
    sb.append("    phrase: ").append(toIndentedString(phrase)).append("\n");
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
