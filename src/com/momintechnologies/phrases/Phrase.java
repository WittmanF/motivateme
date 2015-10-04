// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.momintechnologies.phrases;


public class Phrase
{

    private int phraseId;
    private String phraseText;

    public Phrase()
    {
    }

    public Phrase(int i, String s)
    {
        phraseId = i;
        phraseText = s;
    }

    public int getPhraseId()
    {
        return phraseId;
    }

    public String getPhraseText()
    {
        return phraseText;
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
