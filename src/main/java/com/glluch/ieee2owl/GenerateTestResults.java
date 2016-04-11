/*
 * The MIT License
 *
 * Copyright 2016 Guillem LLuch Moll guillem72@gmail.com.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.glluch.ieee2owl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.SerializationUtils;

/**
 * A class for do some files for tests.
 * @author Guillem LLuch Moll guillem72@gmail.com
 */
public class GenerateTestResults {

    /**
     * Create a file with the desired result for the method testParse.
     * @throws IOException if the file couldn't be written.
     */
    public void IEEEParserParseResult() throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        File target;
        target = new File("resources/test/IEEEParserParseResult.txt");
        lines.add("circuits and systems");
        lines.add("....circuits");
        lines.add("........active circuits");
        
       IEEEParser.parse(lines);
      
        FileUtils.write(target, IEEEParser.toString2());
    }
}
