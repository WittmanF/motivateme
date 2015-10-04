// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.momintechnologies.phrases;

import java.util.Random;

public class Utils
{

    public Utils()
    {
    }

    public static int randInt(int i, int j)
    {
        return (new Random()).nextInt((j - i) + 1) + i;
    }
}
