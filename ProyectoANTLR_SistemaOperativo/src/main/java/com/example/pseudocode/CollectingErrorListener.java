package com.example.pseudocode;

import org.antlr.v4.runtime.*;

public class CollectingErrorListener extends BaseErrorListener {
    private int syntaxErrors = 0;

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine, String msg, RecognitionException e) {
        syntaxErrors++;
    }

    public int getSyntaxErrors() { return syntaxErrors; }
}
