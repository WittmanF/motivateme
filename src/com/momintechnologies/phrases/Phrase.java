// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.momintechnologies.phrases;


public class Phrase
{

    private String phraseAuthor;
    private String phraseCategory;
    private int phraseId;
    private String phraseText;

    public Phrase()
    {
    }

    public Phrase(int i, String s, String s1, String s2)
    {
        phraseId = i;
        phraseText = s;
        phraseAuthor = s1;
        phraseCategory = s2;
    }

    public String getPhraseAuthor()
    {
        return phraseAuthor;
    }

    public String getPhraseCategory()
    {
        return phraseCategory;
    }

    public int getPhraseId()
    {
        return phraseId;
    }

    public String getPhraseText()
    {
        return phraseText;
    }

    public void setPhraseAuthor(String s)
    {
        phraseAuthor = s;
    }

    public void setPhraseCategory(String s)
    {
        phraseCategory = s;
    }

    public void setPhraseId(int i)
    {
        phraseId = i;
    }

    public void setPhraseText(String s)
    {
        phraseText = s;
    }
}
