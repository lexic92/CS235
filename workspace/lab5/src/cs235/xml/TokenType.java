package cs235.xml;

//package cs235.xml;


public enum TokenType {

    /**
     * These constants represent the different kinds of tokens
     * that can appear in an XML file.
     * 
     * BOF          beginning of file, nextToken has never been called
     * START_TAG    start tag token
     * END_TAG      end tag token
     * TEXT         text token
     * EOF          end of file, there are no more tokens
     */ 

	BOF,
	START_TAG,
	END_TAG,
	TEXT,
	EOF
 
}


