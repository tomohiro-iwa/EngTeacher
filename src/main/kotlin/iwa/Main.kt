package main.kotlin.iwa

import edu.stanford.nlp.ling.CoreAnnotations
import edu.stanford.nlp.pipeline.Annotation
import edu.stanford.nlp.pipeline.StanfordCoreNLP
import edu.stanford.nlp.trees.*

import java.util.*

fun main(args: Array<String>){
  var props:Properties = Properties()
  props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse")
  // use faster shift reduce parser
  //props.setProperty("parse.model", "edu/stanford/nlp/models/srparser/englishSR.ser.gz")
  props.setProperty("parse.maxlen", "100")
  props.setProperty("parse.binaryTrees", "true")
  // set up Stanford CoreNLP pipeline
  var pipeline :StanfordCoreNLP = StanfordCoreNLP(props)
  // build annotation for a review
  var annotation :Annotation = Annotation("The small red car turned very quickly around the corner.")
  // annotate
  pipeline.annotate(annotation)
  // get tre    //Set<Constituent> treeConstituents = tree.constituents(new LabeledScoredConstituentFactory());
    //for (Constituent constituent : treeConstituents) {
    //  if (constituent.label() != null &&
    //      (constituent.label().toString().equals("VP") || constituent.label().toString().equals("NP"))) {
    //    System.err.println("found constituent: "+constituent.toString());
    //    System.err.println(tree.getLeaves().subList(constituent.start(), constituent.end()+1));
    //  }
    //}
  var tree :Tree = annotation.get(CoreAnnotations.SentencesAnnotation::class.java)[0].get(TreeCoreAnnotations.TreeAnnotation::class.java)
  print("tree:")
  println(tree)
  print("sentence:")
  println(STreeAnalyzer.toSentence(tree))

}

