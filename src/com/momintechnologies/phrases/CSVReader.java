// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.momintechnologies.phrases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader
{

    public static final char DEFAULT_QUOTE_CHARACTER = 34;
    public static final char DEFAULT_SEPARATOR = 44;
    public static final int DEFAULT_SKIP_LINES = 0;
    private BufferedReader br;
    private boolean hasNext;
    private boolean linesSkiped;
    private char quotechar;
    private char separator;
    private int skipLines;

    public CSVReader(Reader reader)
    {
        this(reader, ',', '"', 0);
    }

    public CSVReader(Reader reader, char c, char c1, int i)
    {
        hasNext = true;
        br = new BufferedReader(reader);
        separator = c;
        quotechar = c1;
        skipLines = i;
    }

    private String getNextLine()
        throws IOException
    {
        if (linesSkiped) goto _L2; else goto _L1
_L1:
        int i = 0;
_L6:
        if (i < skipLines) goto _L4; else goto _L3
_L3:
        linesSkiped = true;
_L2:
        String s = br.readLine();
        if (s == null)
        {
            hasNext = false;
        }
        if (hasNext)
        {
            return s;
        } else
        {
            return null;
        }
_L4:
        br.readLine();
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private String[] parseLine(String s)
        throws IOException
    {
        String s2;
        ArrayList arraylist;
        int i;
        if (s == null)
        {
            return null;
        }
        arraylist = new ArrayList();
        StringBuffer stringbuffer = new StringBuffer();
        i = 0;
        s2 = s;
        s = stringbuffer;
_L5:
        if (i == 0) goto _L2; else goto _L1
_L1:
        String s1;
        s.append("\n");
        s1 = getNextLine();
        s2 = s1;
        if (s1 != null) goto _L2; else goto _L3
_L3:
        arraylist.add(s.toString());
        return (String[])arraylist.toArray(new String[0]);
_L2:
        boolean flag;
        boolean flag1 = false;
        s1 = s;
        flag = i;
        i = ((flag1) ? 1 : 0);
_L6:
        if (i < s2.length())
        {
            break MISSING_BLOCK_LABEL_121;
        }
        i = ((flag) ? 1 : 0);
        s = s1;
        if (flag) goto _L5; else goto _L4
_L4:
        s = s1;
          goto _L3
        char c = s2.charAt(i);
        boolean flag2;
        int j;
        if (c == quotechar)
        {
            if (flag && s2.length() > i + 1 && s2.charAt(i + 1) == quotechar)
            {
                s1.append(s2.charAt(i + 1));
                j = i + 1;
                s = s1;
                flag2 = flag;
            } else
            {
                if (flag)
                {
                    flag = false;
                } else
                {
                    flag = true;
                }
                j = i;
                flag2 = flag;
                s = s1;
                if (i > 2)
                {
                    j = i;
                    flag2 = flag;
                    s = s1;
                    if (s2.charAt(i - 1) != separator)
                    {
                        j = i;
                        flag2 = flag;
                        s = s1;
                        if (s2.length() > i + 1)
                        {
                            j = i;
                            flag2 = flag;
                            s = s1;
                            if (s2.charAt(i + 1) != separator)
                            {
                                s1.append(c);
                                j = i;
                                flag2 = flag;
                                s = s1;
                            }
                        }
                    }
                }
            }
        } else
        if (c == separator && !flag)
        {
            arraylist.add(s1.toString());
            s = new StringBuffer();
            j = i;
            flag2 = flag;
        } else
        {
            s1.append(c);
            j = i;
            flag2 = flag;
            s = s1;
        }
        i = j + 1;
        flag = flag2;
        s1 = s;
          goto _L6
    }

    public void close()
        throws IOException
    {
        br.close();
    }

    public String[] readNext()
        throws IOException
    {
        String s = getNextLine();
        if (hasNext)
        {
            return parseLine(s);
        } else
        {
            return null;
        }
    }
}
