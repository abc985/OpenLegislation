package gov.nysenate.openleg.processor.base;

public class ParseError extends Exception
{
    private static final long serialVersionUID = 2809768377369235106L;

    public ParseError(String message) { super(message); }
}
