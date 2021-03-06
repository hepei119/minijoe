// Copyright 2008 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.minijoe.compiler;

import com.google.minijoe.compiler.ast.Expression;
import com.google.minijoe.compiler.ast.ExpressionStatement;
import com.google.minijoe.compiler.ast.Identifier;
import com.google.minijoe.compiler.ast.NewExpression;
import com.google.minijoe.compiler.ast.NumberLiteral;
import com.google.minijoe.compiler.ast.PropertyExpression;
import com.google.minijoe.compiler.ast.StringLiteral;

/**
 * @author Andy Hayward
 */
public class ParserExpressionStatementTest extends AbstractParserTest {
  public ParserExpressionStatementTest() {
    super();
  }

  public ParserExpressionStatementTest(String name) {
    super(name);
  }

  public void testExpressionStatement() throws CompilerException {
    assertParserOutput(
        new ExpressionStatement(
            new PropertyExpression(
                new NewExpression(
                    new PropertyExpression(
                        new NewExpression(
                            new Identifier("foo"),
                            new Expression[] {
                              new Identifier("String"),
                              new NumberLiteral(2.0)
                            }
                        ),
                        new StringLiteral("bar")
                    ),
                    new Expression[] {
                      new NumberLiteral(42)
                    }
                ),
                new StringLiteral("baz")
            )
        ),
        "new new foo(String, 2).bar(42).baz;"
    );
  }
}
