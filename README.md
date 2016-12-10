# PyriteGarnet
Pyrite Programming Language (code name:Garnet)

# required library
* Antlr (http://www.antlr.org/) - `antlr-4.5.2-complete.jar` で確認

# Pyrite program compile
`java -cp .;\lib\pyrc1.1.0.0.jar;\lib\antlr-4.5.2-complete.jar; pyrite.compiler.Compiler *.pyr`

Java同様、Pyrite ソースファイルのルートをクラスパスに含めてコンパイルを実行する。

# Pyrite program execution
`java -cp .;\lib\pyrt1.1.0.0.jar; HelloPyrite`

Java同様、mainメソッドを持つ.class ファイルを参照できるようにクラスパスを設定して実行する。

# Library
* pyrc1.1.0.0.jar - コンパイラを含むフルパッケージ。下記ランライムも含んでいる。
* pyrt1.1.0.0.jar - Pyrite プログラムのランタイムのみ。


# 未実装
* inner class 
* Generic

# 実装予定
* 現在はコンパイルエラー時、例外を発行して終了するが、一般的なコンパイラのように検出した全てのエラー内容を表示する。
