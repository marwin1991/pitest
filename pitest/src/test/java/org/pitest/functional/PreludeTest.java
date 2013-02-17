/*
 * Copyright 2010 Henry Coles
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and limitations under the License. 
 */
package org.pitest.functional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;

import org.junit.Test;
import org.mockito.Mockito;

public class PreludeTest {

  @Test
  public void isNullShouldReturnsTrueWhenNull() {
    assertTrue(Prelude.isNull().apply(null));
  }

  @Test
  public void isNullShouldReturnFalseWhenNotNull() {
    assertFalse(Prelude.isNull().apply(1));
  }

  @Test
  public void isNotNullShouldReturnFalseWhenNull() {
    assertFalse(Prelude.isNotNull().apply(null));
  }

  @Test
  public void isNotNullShouldReturnTrueWhenNotNull() {
    assertTrue(Prelude.isNotNull().apply(1));
  }
  
  @Test
  public void printToShouldPrintValueToStream() {
    Integer i = Integer.valueOf(42);
    PrintStream stream = Mockito.mock(PrintStream.class);
    Prelude.printTo(stream).apply(i);
    verify(stream).print(i);
  }
  
}
