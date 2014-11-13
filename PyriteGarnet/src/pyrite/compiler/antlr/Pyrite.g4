/*
 [The "BSD licence"]
 Copyright (c) 2013 Terence Parr, Sam Harwell
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

// version 0.0-1

// refer Java1.7.g4
grammar Pyrite;

@header
{
  package pyrite.compiler.antlr;
}

// root
compilationUnit
    :   packageDeclaration? importDeclaration* classDeclaration EOF
    ;

//	compilationUnit
//	    :   packageDeclaration? importDeclaration* typeDeclaration* EOF
//	    ;


packageDeclaration
    :   'package' qualifiedName ';'
    ;

//	packageDeclaration
//	    :   annotation* 'package' qualifiedName ';'
//	    ;

importDeclaration
    :   'import' qualifiedName ('.' ast='*')? ';'
    ;

//		typeDeclaration
//		    :   classModifier classDeclaration
//		    |   classModifier enumDeclaration
//		    |   ';'
//		    ;

//		classModifier
//		    :   accessModifier? inheritanceModifier?
//		    ;

//		accessModifier
//		    :   'public'     // class or interface
//		    |   'protected'  // class or interface
//		    |   'private'    // class or interface
//		    ;

//		inheritanceModifier
//		    :   'final'
//		    ;

classInstanceModifier
    :   'static'
    ;

//		variantModifier
//		    :   'invariant'
//		    |   'variable'
//		    ;

//	typeDeclaration
//	    :   classOrInterfaceModifier* classDeclaration
//	    |   classOrInterfaceModifier* enumDeclaration
//	    |   classOrInterfaceModifier* interfaceDeclaration
//	    |   classOrInterfaceModifier* annotationTypeDeclaration
//	    |   ';'
//	    ;

//	modifier
//	    :   classOrInterfaceModifier
//	    |   (   'native'
//	        |   'synchronized'
//	        |   'transient'
//	        |   'volatile'
//	        )
//	    ;

//	classOrInterfaceModifier
//	    :   annotation       // class or interface
//	    |   (   'public'     // class or interface
//	        |   'protected'  // class or interface
//	        |   'private'    // class or interface
//	        |   'static'     // class or interface
//	        |   'abstract'   // class or interface
//	        |   'final'      // class only -- does not apply to interfaces
//	        |   'strictfp'   // class or interface
//	        )
//	    ;

//	variableModifier
//	    :   'final'
//	    |   annotation
//	    ;


classDeclaration
    :   'class' Identifier ('extends' type)? ('implements' typeList)?
        classBody
    ;

//	classDeclaration
//	    :   'class' Identifier typeParameters?
//	        ('extends' type)?
//	        ('implements' typeList)?
//	        classBody
//	    ;

//	typeParameters
//	    :   '<' typeParameter (',' typeParameter)* '>'
//	    ;

//	typeParameter
//	    :   Identifier ('extends' typeBound)?
//	    ;

//	typeBound
//	    :   type ('&' type)*
//	    ;

//	enumDeclaration
//	    :   ENUM Identifier ('extends' typeList)?
//	        '{' enumConstants? ','? '}'
//	    ;

//	enumDeclaration
//	    :   ENUM Identifier ('implements' typeList)?
//	        '{' enumConstants? ','? enumBodyDeclarations? '}'
//	    ;

//	enumConstants
//	    :   Identifier (',' Identifier)*
//	    ;

//	enumConstants
//	    :   enumConstant (',' enumConstant)*
//	    ;

//	enumConstant
//	    :   annotation* Identifier arguments? classBody?
//	    ;

//	enumBodyDeclarations
//	    :   ';' classBodyDeclaration*
//	    ;

//	interfaceDeclaration
//	    :   'interface' Identifier typeParameters? ('extends' typeList)? interfaceBody
//	    ;

typeList
    :   type (',' type)*
    ;

classBody
    :   '{' classBodyDeclaration* '}'
    ;

//	interfaceBody
//	    :   '{' interfaceBodyDeclaration* '}'
//	    ;

classBodyDeclaration
    :   ';'
    |    constructorDeclaration
    |    methodDeclaration
    |    fieldDeclaration
    ;

//		classBodyDeclaration
//		    :   ';'
//		    |   classInstanceModifier? block
//		    |   memberModifier memberDeclaration
//		    |   fieldModifier fieldDeclaration
//		    |   classModifier classDeclaration
//		    |   classModifier enumDeclaration
//		    ;

//	classBodyDeclaration
//	    :   ';'
//	    |   'static'? block
//	    |   modifier* memberDeclaration
//	    ;

//		memberModifier
//		    :   accessModifier? inheritanceModifier? classInstanceModifier?
//		    ;

//	memberDeclaration
//	    :   methodDeclaration
//	    |   genericMethodDeclaration
//	    |   fieldDeclaration
//	    |   constructorDeclaration
//	    |   genericConstructorDeclaration
//	    |   interfaceDeclaration
//	    |   annotationTypeDeclaration
//	    |   classDeclaration
//	    |   enumDeclaration
//	    ;



//	/* We use rule this even for void methods which cannot have [] after parameters.
//	   This simplifies grammar and we can consider void to be a type, which
//	   renders the [] matching as a context-sensitive issue or a semantic check
//	   for invalid return type after parsing.
//	 */


methodDeclaration
    :   classInstanceModifier? Identifier inputParameters outputParameters
        methodBody
    ;

inputParameters
    :   '(' (inputParameter (',' inputParameter)*)? ')'
    ;

inputParameter
    :   Identifier ':' typeOrArray
    ;

outputParameters
    :   '(' (outputParameter (',' outputParameter)*)? ')'
    ;

outputParameter
    :   (Identifier ':')? typeOrArray
    ;


//	methodDeclaration
//	    :   (type|'void') Identifier formalParameters ('[' ']')*
//	        ('throws' qualifiedNameList)?
//	        (   methodBody
//	        |   ';'
//	        )
//	    ;

//	genericMethodDeclaration
//	    :   typeParameters methodDeclaration
//	    ;

constructorDeclaration
    :   Identifier inputParameters
        constructorBody
    ;
// コンストラクタでコード生成チェック

//	constructorDeclaration
//	    :   Identifier formalParameters ('throws' qualifiedNameList)?
//	        constructorBody
//	    ;

//	genericConstructorDeclaration
//	    :   typeParameters constructorDeclaration
//	    ;

//		fieldModifier
//		    :   accessModifier inheritanceModifier? classInstanceModifier?
//		    |   accessModifier 'get' accessModifier 'set' inheritanceModifier? classInstanceModifier?
//		    ;

fieldDeclaration
    :   classInstanceModifier? 'var' variableDeclarationStatement ';'
    ;


//	fieldDeclaration
//	    :   type variableDeclarators ';'
//	    ;

//	interfaceBodyDeclaration
//	    :   modifier* interfaceMemberDeclaration
//	    |   ';'
//	    ;

//	interfaceMemberDeclaration
//	    :   constDeclaration
//	    |   interfaceMethodDeclaration
//	    |   genericInterfaceMethodDeclaration
//	    |   interfaceDeclaration
//	    |   annotationTypeDeclaration
//	    |   classDeclaration
//	    |   enumDeclaration
//	    ;

//	constDeclaration
//	    :   type constantDeclarator (',' constantDeclarator)* ';'
//	    ;

//	constantDeclarator
//	    :   Identifier ('[' ']')* '=' variableInitializer
//	    ;

//	// see matching of [] comment in methodDeclaratorRest
//	interfaceMethodDeclaration
//	    :   (type|'void') Identifier formalParameters ('[' ']')*
//	        ('throws' qualifiedNameList)?
//	        ';'
//	    ;

//	genericInterfaceMethodDeclaration
//	    :   typeParameters interfaceMethodDeclaration
//	    ;

//	variableDeclarators
//	    :   variableDeclarator (',' variableDeclarator)*
//	    ;

//	variableDeclarator
//	    :   variableDeclaratorId ('=' variableInitializer)?
//	    ;

//	variableDeclaratorId
//	    :   Identifier ('[' ']')*
//	    ;

//	variableInitializer
//	    :   arrayInitializer
//	    |   expression
//	    ;

//	arrayInitializer
//	    :   '{' (variableInitializer (',' variableInitializer)* (',')? )? '}'
//	    ;

//	enumConstantName
//	    :   Identifier
//	    ;

typeOrArray
    :   type
    |   array
    ;

type
    :   primitiveType
    |   qualifiedName
    ;

array
    :   '[' arraySpec ']'
    ;

arraySpec
    :   type			# ArraySpecType		// not used
    |   type ':' type	# ArraySpecAssoc
    |   array			# ArraySpecArray	// not used
    ;


//	type
//	    :   classOrInterfaceType ('[' ']')*
//	    |   primitiveType ('[' ']')*
//	    ;

//	classOrInterfaceType
//	    :   Identifier ('.' Identifier)*
//	    ;

//	classOrInterfaceType
//	    :   Identifier typeArguments? ('.' Identifier typeArguments? )*
//	    ;

primitiveType
    :   'obj'
    |   'num'
    |   'int'
    |   'flt'
    |   'str'
    |   'chr'
    |   'bol'
    |   'byt'
    ;

//	primitiveType
//	    :   'boolean'
//	    |   'char'
//	    |   'byte'
//	    |   'short'
//	    |   'int'
//	    |   'long'
//	    |   'float'
//	    |   'double'
//	    ;

//	typeArguments
//	    :   '<' typeArgument (',' typeArgument)* '>'
//	    ;

//	typeArgument
//	    :   type
//	    |   '?' (('extends' | 'super') type)?
//	    ;

//	qualifiedNameList
//	    :   qualifiedName (',' qualifiedName)*
//	    ;

//	formalParameters
//	    :   '(' formalParameterList? ')'
//	    ;

//	formalParameterList
//	    :   formalParameter (',' formalParameter)*
//	    ;

//	formalParameterList
//	    :   formalParameter (',' formalParameter)* (',' lastFormalParameter)?
//	    |   lastFormalParameter
//	    ;

//	formalParameter
//	    :   type variableDeclaratorId
//	    ;

//	formalParameter
//	    :   variableModifier* type variableDeclaratorId
//	    ;

//	lastFormalParameter
//	    :   variableModifier* type '...' variableDeclaratorId
//	    ;

methodBody
    :   block
    ;

constructorBody
    :   block
    ;

qualifiedName
    :   Identifier ('.' Identifier)*
    ;

literal
    :   integerLiteral
    |   floatingPointLiteral
    |   characterLiteral
    |   stringLiteral
    |   booleanLiteral
    |   nullLiteral
    ;

//	literal
//	    :   IntegerLiteral
//	    |   FloatingPointLiteral
//	    |   CharacterLiteral
//	    |   StringLiteral
//	    |   BooleanLiteral
//	    |   'null'
//	    ;

// TODO:FloatingPointLiteral, CharacterLiteral,


//	// ANNOTATIONS

//	annotation
//	    :   '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )?
//	    ;

//	annotationName : qualifiedName ;

//	elementValuePairs
//	    :   elementValuePair (',' elementValuePair)*
//	    ;

//	elementValuePair
//	    :   Identifier '=' elementValue
//	    ;

//	elementValue
//	    :   expression
//	    |   annotation
//	    |   elementValueArrayInitializer
//	    ;

//	elementValueArrayInitializer
//	    :   '{' (elementValue (',' elementValue)*)? (',')? '}'
//	    ;

//	annotationTypeDeclaration
//	    :   '@' 'interface' Identifier annotationTypeBody
//	    ;

//	annotationTypeBody
//	    :   '{' (annotationTypeElementDeclaration)* '}'
//	    ;

//	annotationTypeElementDeclaration
//	    :   modifier* annotationTypeElementRest
//	    |   ';' // this is not allowed by the grammar, but apparently allowed by the actual compiler
//	    ;

//	annotationTypeElementRest
//	    :   type annotationMethodOrConstantRest ';'
//	    |   classDeclaration ';'?
//	    |   interfaceDeclaration ';'?
//	    |   enumDeclaration ';'?
//	    |   annotationTypeDeclaration ';'?
//	    ;

//	annotationMethodOrConstantRest
//	    :   annotationMethodRest
//	    |   annotationConstantRest
//	    ;

//	annotationMethodRest
//	    :   Identifier '(' ')' defaultValue?
//	    ;

//	annotationConstantRest
//	    :   variableDeclarators
//	    ;

//	defaultValue
//	    :   'default' elementValue
//	    ;

// STATEMENTS / BLOCKS

block
    :   '{' statement* '}'
    ;

//	block
//	    :   '{' blockStatement* '}'
//	    ;

//	blockStatement
//	    :   localVariableDeclarationStatement
//	    |   statement
//	    |   typeDeclaration
//	    ;

//	localVariableDeclarationStatement
//	    :    localVariableDeclaration ';'
//	    ;

//	localVariableDeclaration
//	    :   variableModifier* type variableDeclarators
//	    ;

statement
    :   block								# StatementBlock	// not used
    |   ';'									# StatementEmpty	// not used
    |   expression ';'						# StatementExpression	// not used
    |   'return' expressionList? ';'		# StatementReturn
    |   'if' ifStatement							# StatementIf		// not used
    |   label 'while' parExpression block			# StatementWhile
    |   label 'for' '(' forControl ')' block		# StatementFor
    |   'switch' parExpression '{' switchBlockStatementGroup* switchLabel* '}'	# StatementSwitch
    |   'break' label ';'				# StatementBreak
    |   'continue' label ';'			# StatementContinue
    |   'var' variableDeclarationStatement ';' 			# StatementVar
    ;

variableDeclarationStatement
    :   Identifier (':' typeOrArray)? ('=' expression)?
    ;

label
    :    Identifier?
    ;

ifStatement
    :	parExpression fulfillmentBlock=block ('else' (ifStatement | elseBlock=block))?	// 'if' parExpression block ('else' (ifStatement | block))?
    ;

//TODO:try-catch, synchronized, throw

//	statement
//	    :   block
//	    |   ASSERT expression (':' expression)? ';'
//	    |   'if' parExpression statement ('else' statement)?
//	    |   'for' '(' forControl ')' statement
//	    |   'while' parExpression statement
//	    |   'do' statement 'while' parExpression ';'
//	    |   'try' block (catchClause+ finallyBlock? | finallyBlock)
//	    |   'try' resourceSpecification block catchClause* finallyBlock?
//	    |   'switch' parExpression '{' switchBlockStatementGroup* switchLabel* '}'
//	    |   'synchronized' parExpression block
//	    |   'return' expression? ';'
//	    |   'throw' expression ';'
//	    |   'break' Identifier? ';'
//	    |   'continue' Identifier? ';'
//	    |   ';'
//	    |   statementExpression ';'
//	    |   Identifier ':' statement
//	    ;

//	catchClause
//	    :   'catch' '(' catchType Identifier ')' block
//	    ;

//	catchClause
//	    :   'catch' '(' variableModifier* catchType Identifier ')' block
//	    ;


//	catchType
//	    :   qualifiedName ('|' qualifiedName)*
//	    ;

//	finallyBlock
//	    :   'finally' block
//	    ;

//	resourceSpecification
//	    :   '(' resources ';'? ')'
//	    ;

//	resources
//	    :   resource (';' resource)*
//	    ;

//	resource
//	    :   classOrInterfaceType variableDeclaratorId '=' expression
//	    ;

//	resource
//	    :   variableModifier* classOrInterfaceType variableDeclaratorId '=' expression
//	    ;

/** Matches cases then statements, both of which are mandatory.
 *  To handle empty cases at the end, we add switchLabel* to statement.
 */

switchBlockStatementGroup
    :   switchLabel+ statement+ (fallthrough='fallthrough' ';')?	// switchLabel+ blockStatement+ ('fallthrough' ';')?
    ;

//	switchBlockStatementGroup
//	    :   switchLabel+ blockStatement+
//	    ;

switchLabel
    :   'case' integerLiteral ':'	# SwitchLabelCaseInt
    |   'case' stringLiteral ':'	# SwitchLabelCaseStr
    |   'default' ':'		# SwitchLabelDefault
    ;

//	switchLabel
//	    :   'case' constantExpression ':'
//	    |   'case' enumConstantName ':'
//	    |   'default' ':'
//	    ;


forControl
    :   'var' Identifier ':' typeOrArray 'in' expression		# ForControlIterator
    |   forInit? ';' expression? ';' forUpdate?					# ForControlICU	// ICU=Init, Control, Update
    ;

//	forControl
//	    :   enhancedForControl
//	    |   forInit? ';' expression? ';' forUpdate?
//	    ;

forInit
    :   forInitSpec+
    ;

forInitSpec
	:	'var' variableDeclarationStatement
	|	expression
	;

// TODO:forInit orig exists?

//	enhancedForControl
//	    :   type variableDeclaratorId ':' expression
//	    ;

//	enhancedForControl
//	    :   variableModifier* type variableDeclaratorId ':' expression
//	    ;

forUpdate
    :   expressionList
    ;

// EXPRESSIONS

parExpression
    :   '(' expression ')'
    ;

expressionList
    :   expression (',' expression)*
    ;

//	statementExpression
//	    :   expression
//	    ;

//	constantExpression
//	    :   expression
//	    ;

expression
    :   primary                     		# ExpressionPrimary	// not used
    |   expression '.' Identifier			# ExpressionClassFieldRef
    |   expression arguments				# ExpressionInvokeMethod
    |   'new' creator						# ExpressionNew
    |   expression '[' expression ']'		# ExpressionArrayAccess
    |   expression op=('*'|'/'|'%') expression	# ExpressionMulDiv
    |   expression op=('+'|'-') expression	# ExpressionAddSub
    |   expression op=('<<' | '>>>' | '>>') expression	# ExpressionShift
    |   expression op=('<=' | '>=' | '>' | '<') expression	# ExpressionCompare
    |   expression op=('==' | '!=') expression	# ExpressionEqual
    |   expression '&' expression	# ExpressionBitAnd
    |   expression '^' expression	# ExpressionBitExOr
    |   expression '|' expression	# ExpressionBitOr
    |   expression '&&' expression	# ExpressionBolAnd
    |   expression '||' expression	# ExpressionBolOr
    |   <assoc=right> expression
        op=('='
        |   '+='
        |   '-='
        |   '*='
        |   '/='
        |   '&='
        |   '|='
        |   '^='
        |   '>>='
        |   '>>>='
        |   '<<='
        |   '%='
        )
        expression					# ExpressionAssign
    ;


//	expression
//	    :   primary
//	    |   expression '.' Identifier
//	    |   expression '.' 'this'
//	    |   expression '.' 'new' nonWildcardTypeArguments? innerCreator
//	    |   expression '.' 'super' superSuffix
//	    |   expression '.' explicitGenericInvocation
//	    |   expression '[' expression ']'
//	    |   expression '(' expressionList? ')'
//	    |   'new' creator
//	    |   '(' type ')' expression
//	    |   expression ('++' | '--')
//	    |   ('+'|'-'|'++'|'--') expression
//	    |   ('~'|'!') expression
//	    |   expression ('*'|'/'|'%') expression
//	    |   expression ('+'|'-') expression
//	    |   expression ('<' '<' | '>' '>' '>' | '>' '>') expression
//	    |   expression ('<=' | '>=' | '>' | '<') expression
//	    |   expression 'instanceof' type
//	    |   expression ('==' | '!=') expression
//	    |   expression '&' expression
//	    |   expression '^' expression
//	    |   expression '|' expression
//	    |   expression '&&' expression
//	    |   expression '||' expression
//	    |   expression '?' expression ':' expression
//	    |   expression
//	        (   '='<assoc=right>
//	        |   '+='<assoc=right>
//	        |   '-='<assoc=right>
//	        |   '*='<assoc=right>
//	        |   '/='<assoc=right>
//	        |   '&='<assoc=right>
//	        |   '|='<assoc=right>
//	        |   '^='<assoc=right>
//	        |   '>>='<assoc=right>
//	        |   '>>>='<assoc=right>
//	        |   '<<='<assoc=right>
//	        |   '%='<assoc=right>
//	        )
//	        expression
//	    ;

primary
    :	'(' expression ')'		# primaryParens
    |	literal                 # primaryLiteral		// not used
    |   Identifier              # primaryIdentifier
    ;

//	primary
//	    :   '(' expression ')'
//	    |   'this'
//	    |   'super'
//	    |   literal
//	    |   Identifier
//	    |   type '.' 'class'
//	    |   'void' '.' 'class'
//	    |   nonWildcardTypeArguments (explicitGenericInvocationSuffix | 'this' arguments)
//	    ;

creator
    :   qualifiedName arguments
    |   array '(' ')'
    ;

//	creator
//	    :   nonWildcardTypeArguments createdName classCreatorRest
//	    |   createdName (arrayCreatorRest | classCreatorRest)
//	    ;

//	createdName
//	    :   Identifier ('.' Identifier)*		# CreatedNameIdentifer
//	    |   primitiveType						# CreatedNamePrimitiveType
//	    ;

//	createdName
//	    :   Identifier typeArgumentsOrDiamond? ('.' Identifier typeArgumentsOrDiamond?)*
//	    |   primitiveType
//	    ;

//	innerCreator
//	    :   Identifier classCreatorRest
//	    ;

//	innerCreator
//	    :   Identifier nonWildcardTypeArgumentsOrDiamond? classCreatorRest
//	    ;

//	arrayCreatorRest
//	    :   '['
//	        (   ']' ('[' ']')* arrayInitializer
//	        |   expression ']' ('[' expression ']')* ('[' ']')*
//	        )
//	    ;

//	classCreatorRest
//	    :   arguments classBody?
//	    ;

//	explicitGenericInvocation
//	    :   explicitGenericInvocationSuffix
//	    ;

//	explicitGenericInvocation
//	    :   nonWildcardTypeArguments explicitGenericInvocationSuffix
//	    ;

//	nonWildcardTypeArguments
//	    :   '<' typeList '>'
//	    ;

//	typeArgumentsOrDiamond
//	    :   '<' '>'
//	    |   typeArguments
//	    ;

//	nonWildcardTypeArgumentsOrDiamond
//	    :   '<' '>'
//	    |   nonWildcardTypeArguments
//	    ;

//	superSuffix
//	    :   arguments
//	    |   '.' Identifier arguments?
//	    ;

//	explicitGenericInvocationSuffix
//	    :   'super' superSuffix
//	    |   Identifier arguments
//	    ;

arguments
    :   '(' expressionList? ')'
    ;



// §3.10.1 Integer Literals

integerLiteral
    :   DecimalNumeral	# IntegerLiteralDecimal
    |   HexNumeral		# IntegerLiteralHex
    |   OctalNumeral	# IntegerLiteralOctal
    |   BinaryNumeral	# IntegerLiteralBinary
    ;

//	IntegerLiteral
//	    :   DecimalIntegerLiteral
//	    |   HexIntegerLiteral
//	    |   OctalIntegerLiteral
//	    |   BinaryIntegerLiteral
//	    ;

//	fragment
//	DecimalIntegerLiteral
//	    :   DecimalNumeral IntegerTypeSuffix?
//	    ;

//	fragment
//	HexIntegerLiteral
//	    :   HexNumeral IntegerTypeSuffix?
//	    ;

//	fragment
//	OctalIntegerLiteral
//	    :   OctalNumeral IntegerTypeSuffix?
//	    ;

//	fragment
//	BinaryIntegerLiteral
//	    :   BinaryNumeral IntegerTypeSuffix?
//	    ;

//	fragment
//	IntegerTypeSuffix
//	    :   [lL]
//	    ;

//	fragment
DecimalNumeral
    :   '0'
    |   NonZeroDigit (Digits? | Underscores Digits)
    ;

//	fragment
Digits
    :   Digit (DigitOrUnderscore* Digit)?
    ;

fragment
Digit
    :   '0'
    |   NonZeroDigit
    ;

fragment
NonZeroDigit
    :   [1-9]
    ;

fragment
DigitOrUnderscore
    :   Digit
    |   '_'
    ;

fragment
Underscores
    :   '_'+
    ;

//	fragment
HexNumeral
    :   '0' [xX] HexDigits
    ;

fragment
HexDigits
    :   HexDigit (HexDigitOrUnderscore* HexDigit)?
    ;

fragment
HexDigit
    :   [0-9a-fA-F]
    ;

fragment
HexDigitOrUnderscore
    :   HexDigit
    |   '_'
    ;

OctalNumeral
    :   '0' [cC] OctalDigits
    ;

//	fragment
//	OctalNumeral
//	    :   '0' Underscores? OctalDigits
//	    ;

fragment
OctalDigits
    :   OctalDigit (OctalDigitOrUnderscore* OctalDigit)?
    ;

fragment
OctalDigit
    :   [0-7]
    ;

fragment
OctalDigitOrUnderscore
    :   OctalDigit
    |   '_'
    ;

//	fragment
BinaryNumeral
    :   '0' [bB] BinaryDigits
    ;

fragment
BinaryDigits
    :   BinaryDigit (BinaryDigitOrUnderscore* BinaryDigit)?
    ;

fragment
BinaryDigit
    :   [01]
    ;

fragment
BinaryDigitOrUnderscore
    :   BinaryDigit
    |   '_'
    ;

// §3.10.2 Floating-Point Literals

floatingPointLiteral
    :   Digits? '.' Digits
    ;

//	FloatingPointLiteral
//	    :   DecimalFloatingPointLiteral
//	    |   HexadecimalFloatingPointLiteral
//	    ;

//	fragment
//	DecimalFloatingPointLiteral
//	    :   Digits '.' Digits? ExponentPart? FloatTypeSuffix?
//	    |   '.' Digits ExponentPart? FloatTypeSuffix?
//	    |   Digits ExponentPart FloatTypeSuffix?
//	    |   Digits FloatTypeSuffix
//	    ;

//	fragment
//	ExponentPart
//	    :   ExponentIndicator SignedInteger
//	    ;

//	fragment
//	ExponentIndicator
//	    :   [eE]
//	    ;

//	fragment
//	SignedInteger
//	    :   Sign? Digits
//	    ;

//	fragment
//	Sign
//	    :   [+-]
//	    ;

//	fragment
//	FloatTypeSuffix
//	    :   [fFdD]
//	    ;

//	fragment
//	HexadecimalFloatingPointLiteral
//	    :   HexSignificand BinaryExponent FloatTypeSuffix?
//	    ;

//	fragment
//	HexSignificand
//	    :   HexNumeral '.'?
//	    |   '0' [xX] HexDigits? '.' HexDigits
//	    ;

//	fragment
//	BinaryExponent
//	    :   BinaryExponentIndicator SignedInteger
//	    ;

//	fragment
//	BinaryExponentIndicator
//	    :   [pP]
//	    ;

// §3.10.3 Boolean Literals

booleanLiteral
    :   'true'
    |   'false'
    ;

//	BooleanLiteral
//	    :   'true'
//	    |   'false'
//	    ;

// §3.10.4 Character Literals

characterLiteral
    :    CharacterLiteral
    ;

CharacterLiteral
    :   '\'' SingleCharacter '\''
    |   '\'' EscapeSequence '\''
    ;

//	CharacterLiteral
//	    :   '\'' SingleCharacter '\''
//	    |   '\'' EscapeSequence '\''
//	    ;

fragment
SingleCharacter
    :   ~['\\]
    ;

// §3.10.5 String Literals

stringLiteral
    :    StringLiteral
    ;

StringLiteral
    :   '"' StringCharacters? '"'
    ;

//	StringLiteral
//	    :   '"' StringCharacters? '"'
//	    ;

fragment
StringCharacters
    :   StringCharacter+
    ;

fragment
StringCharacter
    :   ~["\\]
    |   EscapeSequence
    ;

// §3.10.6 Escape Sequences for Character and String Literals

fragment
EscapeSequence
    :   '\\' [btnfr"'\\]
    |   OctalEscape
    |   UnicodeEscape
    ;

fragment
OctalEscape
    :   '\\' OctalDigit
    |   '\\' OctalDigit OctalDigit
    |   '\\' ZeroToThree OctalDigit OctalDigit
    ;

fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

fragment
ZeroToThree
    :   [0-3]
    ;

// §3.10.7 The Null Literal

nullLiteral
    :   'null'
    ;

//	NullLiteral
//	    :   'null'
//	    ;

// LEXER

// §3.9 Keywords

//	ABSTRACT      : 'abstract';
//	ASSERT        : 'assert';
//	BOOLEAN       : 'boolean';
BREAK         : 'break';
//	BYTE          : 'byte';
CASE          : 'case';
CATCH         : 'catch';
//	CHAR          : 'char';
CLASS         : 'class';
CONST         : 'const';
CONTINUE      : 'continue';
DEFAULT       : 'default';
//	DO            : 'do';
//	DOUBLE        : 'double';
ELSE          : 'else';
ENUM          : 'enum';
EXTENDS       : 'extends';
FINAL         : 'final';
FINALLY       : 'finally';
//	FLOAT         : 'float';
FOR           : 'for';
IF            : 'if';
//	GOTO          : 'goto';
IMPLEMENTS    : 'implements';
IMPORT        : 'import';
INSTANCEOF    : 'instanceof';
//	INT           : 'int';
INTERFACE     : 'interface';
//	LONG          : 'long';
//	NATIVE        : 'native';
NEW           : 'new';
PACKAGE       : 'package';
PRIVATE       : 'private';
PROTECTED     : 'protected';
PUBLIC        : 'public';
RETURN        : 'return';
//	SHORT         : 'short';
STATIC        : 'static';
//	STRICTFP      : 'strictfp';
SUPER         : 'super';
SWITCH        : 'switch';
SYNCHRONIZED  : 'synchronized';
THIS          : 'this';
THROW         : 'throw';
THROWS        : 'throws';
//	TRANSIENT     : 'transient';
TRY           : 'try';
VOID          : 'void';
//	VOLATILE      : 'volatile';
WHILE         : 'while';

VAR : 'var';
OBJ : 'obj';
NUM : 'num';
INT : 'int';
FLT : 'flt';
STR : 'str';
CHR : 'chr';
BOL : 'bol';
BYT : 'byt';

IN : 'in';


// §3.11 Separators

LPAREN          : '(';
RPAREN          : ')';
LBRACE          : '{';
RBRACE          : '}';
LBRACK          : '[';
RBRACK          : ']';
SEMI            : ';';
COMMA           : ',';
DOT             : '.';

// §3.12 Operators

ASSIGN          : '=';
GT              : '>';
LT              : '<';
BANG            : '!';
TILDE           : '~';
QUESTION        : '?';
COLON           : ':';
EQUAL           : '==';
LE              : '<=';
GE              : '>=';
NOTEQUAL        : '!=';
AND             : '&&';
OR              : '||';
INC             : '++';
DEC             : '--';
ADD             : '+';
SUB             : '-';
MUL             : '*';
DIV             : '/';
BITAND          : '&';
BITOR           : '|';
CARET           : '^';
MOD             : '%';

ADD_ASSIGN      : '+=';
SUB_ASSIGN      : '-=';
MUL_ASSIGN      : '*=';
DIV_ASSIGN      : '/=';
AND_ASSIGN      : '&=';
OR_ASSIGN       : '|=';
XOR_ASSIGN      : '^=';
MOD_ASSIGN      : '%=';
LSHIFT_ASSIGN   : '<<=';
RSHIFT_ASSIGN   : '>>=';
URSHIFT_ASSIGN  : '>>>=';

// §3.8 Identifiers (must appear after all keywords in the grammar)

Identifier
    :   JavaLetter JavaLetterOrDigit*
    ;

fragment
JavaLetter
    :   [a-zA-Z$_] // these are the "java letters" below 0xFF
    |   // covers all characters above 0xFF which are not a surrogate
        ~[\u0000-\u00FF\uD800-\uDBFF]
        {Character.isJavaIdentifierStart(_input.LA(-1))}?
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
        {Character.isJavaIdentifierStart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;

fragment
JavaLetterOrDigit
    :   [a-zA-Z0-9$_] // these are the "java letters or digits" below 0xFF
    |   // covers all characters above 0xFF which are not a surrogate
        ~[\u0000-\u00FF\uD800-\uDBFF]
        {Character.isJavaIdentifierPart(_input.LA(-1))}?
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
        {Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;

//
// Additional symbols not defined in the lexical specification
//

AT : '@';
ELLIPSIS : '...';

//
// Whitespace and comments
//

WS  :  [ \t\r\n\u000C]+ -> skip
    ;

COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;
