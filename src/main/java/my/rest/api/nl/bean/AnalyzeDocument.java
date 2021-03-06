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
 * Analysis data
 */

public class AnalyzeDocument {

  private String version = null;


  private String language = null;

  private List<Paragraph> paragraphs = null;

  private List<Sentence> sentences = null;

  private List<Phrase> phrases = null;

  private List<Token> tokens = null;

  private List<MainSentence> mainSentences = null;

  private List<MainPhrase> mainPhrases = null;

  private List<MainLemma> mainLemmas = null;

  private List<MainSyncon> mainSyncons = null;

  private List<Entity> entities = null;

  private List<DocumentTopic> topics = null;

  private List<KnowledgeEntry> knowledge = null;

  private AnalyzeDocumentSentiment sentiment = null;

  private List<Relation> relations = null;

  public AnalyzeDocument version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Service version
   * @return version
  **/
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public AnalyzeDocument language(String language) {
    this.language = language;
    return this;
  }

   /**
   * Text language
   * @return language
  **/
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public AnalyzeDocument paragraphs(List<Paragraph> paragraphs) {
    this.paragraphs = paragraphs;
    return this;
  }

  public AnalyzeDocument addParagraphsItem(Paragraph paragraphsItem) {
    if (this.paragraphs == null) {
      this.paragraphs = new ArrayList<Paragraph>();
    }
    this.paragraphs.add(paragraphsItem);
    return this;
  }

   /**
   * Paragraphs
   * @return paragraphs
  **/
  public List<Paragraph> getParagraphs() {
    return paragraphs;
  }

  public void setParagraphs(List<Paragraph> paragraphs) {
    this.paragraphs = paragraphs;
  }

  public AnalyzeDocument sentences(List<Sentence> sentences) {
    this.sentences = sentences;
    return this;
  }

  public AnalyzeDocument addSentencesItem(Sentence sentencesItem) {
    if (this.sentences == null) {
      this.sentences = new ArrayList<Sentence>();
    }
    this.sentences.add(sentencesItem);
    return this;
  }

   /**
   * Sentences
   * @return sentences
  **/
  public List<Sentence> getSentences() {
    return sentences;
  }

  public void setSentences(List<Sentence> sentences) {
    this.sentences = sentences;
  }

  public AnalyzeDocument phrases(List<Phrase> phrases) {
    this.phrases = phrases;
    return this;
  }

  public AnalyzeDocument addPhrasesItem(Phrase phrasesItem) {
    if (this.phrases == null) {
      this.phrases = new ArrayList<Phrase>();
    }
    this.phrases.add(phrasesItem);
    return this;
  }

   /**
   * Phrases
   * @return phrases
  **/
  public List<Phrase> getPhrases() {
    return phrases;
  }

  public void setPhrases(List<Phrase> phrases) {
    this.phrases = phrases;
  }

  public AnalyzeDocument tokens(List<Token> tokens) {
    this.tokens = tokens;
    return this;
  }

  public AnalyzeDocument addTokensItem(Token tokensItem) {
    if (this.tokens == null) {
      this.tokens = new ArrayList<Token>();
    }
    this.tokens.add(tokensItem);
    return this;
  }

   /**
   * Tokens
   * @return tokens
  **/
  public List<Token> getTokens() {
    return tokens;
  }

  public void setTokens(List<Token> tokens) {
    this.tokens = tokens;
  }

  public AnalyzeDocument mainSentences(List<MainSentence> mainSentences) {
    this.mainSentences = mainSentences;
    return this;
  }

  public AnalyzeDocument addMainSentencesItem(MainSentence mainSentencesItem) {
    if (this.mainSentences == null) {
      this.mainSentences = new ArrayList<MainSentence>();
    }
    this.mainSentences.add(mainSentencesItem);
    return this;
  }

   /**
   * Main sentences
   * @return mainSentences
  **/
  public List<MainSentence> getMainSentences() {
    return mainSentences;
  }

  public void setMainSentences(List<MainSentence> mainSentences) {
    this.mainSentences = mainSentences;
  }

  public AnalyzeDocument mainPhrases(List<MainPhrase> mainPhrases) {
    this.mainPhrases = mainPhrases;
    return this;
  }

  public AnalyzeDocument addMainPhrasesItem(MainPhrase mainPhrasesItem) {
    if (this.mainPhrases == null) {
      this.mainPhrases = new ArrayList<MainPhrase>();
    }
    this.mainPhrases.add(mainPhrasesItem);
    return this;
  }

   /**
   * Main phrases
   * @return mainPhrases
  **/
  public List<MainPhrase> getMainPhrases() {
    return mainPhrases;
  }

  public void setMainPhrases(List<MainPhrase> mainPhrases) {
    this.mainPhrases = mainPhrases;
  }

  public AnalyzeDocument mainLemmas(List<MainLemma> mainLemmas) {
    this.mainLemmas = mainLemmas;
    return this;
  }

  public AnalyzeDocument addMainLemmasItem(MainLemma mainLemmasItem) {
    if (this.mainLemmas == null) {
      this.mainLemmas = new ArrayList<MainLemma>();
    }
    this.mainLemmas.add(mainLemmasItem);
    return this;
  }

   /**
   * Main lemmas
   * @return mainLemmas
  **/
  public List<MainLemma> getMainLemmas() {
    return mainLemmas;
  }

  public void setMainLemmas(List<MainLemma> mainLemmas) {
    this.mainLemmas = mainLemmas;
  }

  public AnalyzeDocument mainSyncons(List<MainSyncon> mainSyncons) {
    this.mainSyncons = mainSyncons;
    return this;
  }

  public AnalyzeDocument addMainSynconsItem(MainSyncon mainSynconsItem) {
    if (this.mainSyncons == null) {
      this.mainSyncons = new ArrayList<MainSyncon>();
    }
    this.mainSyncons.add(mainSynconsItem);
    return this;
  }

   /**
   * Main syncons
   * @return mainSyncons
  **/
  public List<MainSyncon> getMainSyncons() {
    return mainSyncons;
  }

  public void setMainSyncons(List<MainSyncon> mainSyncons) {
    this.mainSyncons = mainSyncons;
  }

  public AnalyzeDocument entities(List<Entity> entities) {
    this.entities = entities;
    return this;
  }

  public AnalyzeDocument addEntitiesItem(Entity entitiesItem) {
    if (this.entities == null) {
      this.entities = new ArrayList<Entity>();
    }
    this.entities.add(entitiesItem);
    return this;
  }

   /**
   * Entities
   * @return entities
  **/
  public List<Entity> getEntities() {
    return entities;
  }

  public void setEntities(List<Entity> entities) {
    this.entities = entities;
  }

  public AnalyzeDocument topics(List<DocumentTopic> topics) {
    this.topics = topics;
    return this;
  }

  public AnalyzeDocument addTopicsItem(DocumentTopic topicsItem) {
    if (this.topics == null) {
      this.topics = new ArrayList<DocumentTopic>();
    }
    this.topics.add(topicsItem);
    return this;
  }

   /**
   * Knowledge Graph topics
   * @return topics
  **/
  public List<DocumentTopic> getTopics() {
    return topics;
  }

  public void setTopics(List<DocumentTopic> topics) {
    this.topics = topics;
  }

  public AnalyzeDocument knowledge(List<KnowledgeEntry> knowledge) {
    this.knowledge = knowledge;
    return this;
  }

  public AnalyzeDocument addKnowledgeItem(KnowledgeEntry knowledgeItem) {
    if (this.knowledge == null) {
      this.knowledge = new ArrayList<KnowledgeEntry>();
    }
    this.knowledge.add(knowledgeItem);
    return this;
  }

   /**
   * Knowledge Graph syncons data
   * @return knowledge
  **/
  public List<KnowledgeEntry> getKnowledge() {
    return knowledge;
  }

  public void setKnowledge(List<KnowledgeEntry> knowledge) {
    this.knowledge = knowledge;
  }

  public AnalyzeDocument sentiment(AnalyzeDocumentSentiment sentiment) {
    this.sentiment = sentiment;
    return this;
  }

   /**
   * Get sentiment
   * @return sentiment
  **/
  public AnalyzeDocumentSentiment getSentiment() {
    return sentiment;
  }

  public void setSentiment(AnalyzeDocumentSentiment sentiment) {
    this.sentiment = sentiment;
  }

  public AnalyzeDocument relations(List<Relation> relations) {
    this.relations = relations;
    return this;
  }

  public AnalyzeDocument addRelationsItem(Relation relationsItem) {
    if (this.relations == null) {
      this.relations = new ArrayList<Relation>();
    }
    this.relations.add(relationsItem);
    return this;
  }

   /**
   * Verb-mediated relations
   * @return relations
  **/
  public List<Relation> getRelations() {
    return relations;
  }

  public void setRelations(List<Relation> relations) {
    this.relations = relations;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnalyzeDocument analyzeDocument = (AnalyzeDocument) o;
    return Objects.equals(this.version, analyzeDocument.version) &&
        Objects.equals(this.language, analyzeDocument.language) &&
        Objects.equals(this.paragraphs, analyzeDocument.paragraphs) &&
        Objects.equals(this.sentences, analyzeDocument.sentences) &&
        Objects.equals(this.phrases, analyzeDocument.phrases) &&
        Objects.equals(this.tokens, analyzeDocument.tokens) &&
        Objects.equals(this.mainSentences, analyzeDocument.mainSentences) &&
        Objects.equals(this.mainPhrases, analyzeDocument.mainPhrases) &&
        Objects.equals(this.mainLemmas, analyzeDocument.mainLemmas) &&
        Objects.equals(this.mainSyncons, analyzeDocument.mainSyncons) &&
        Objects.equals(this.entities, analyzeDocument.entities) &&
        Objects.equals(this.topics, analyzeDocument.topics) &&
        Objects.equals(this.knowledge, analyzeDocument.knowledge) &&
        Objects.equals(this.sentiment, analyzeDocument.sentiment) &&
        Objects.equals(this.relations, analyzeDocument.relations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, language, paragraphs, sentences, phrases, tokens, mainSentences, mainPhrases, mainLemmas, mainSyncons, entities, topics, knowledge, sentiment, relations);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnalyzeDocument {\n");
    
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    paragraphs: ").append(toIndentedString(paragraphs)).append("\n");
    sb.append("    sentences: ").append(toIndentedString(sentences)).append("\n");
    sb.append("    phrases: ").append(toIndentedString(phrases)).append("\n");
    sb.append("    tokens: ").append(toIndentedString(tokens)).append("\n");
    sb.append("    mainSentences: ").append(toIndentedString(mainSentences)).append("\n");
    sb.append("    mainPhrases: ").append(toIndentedString(mainPhrases)).append("\n");
    sb.append("    mainLemmas: ").append(toIndentedString(mainLemmas)).append("\n");
    sb.append("    mainSyncons: ").append(toIndentedString(mainSyncons)).append("\n");
    sb.append("    entities: ").append(toIndentedString(entities)).append("\n");
    sb.append("    topics: ").append(toIndentedString(topics)).append("\n");
    sb.append("    knowledge: ").append(toIndentedString(knowledge)).append("\n");
    sb.append("    sentiment: ").append(toIndentedString(sentiment)).append("\n");
    sb.append("    relations: ").append(toIndentedString(relations)).append("\n");
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
