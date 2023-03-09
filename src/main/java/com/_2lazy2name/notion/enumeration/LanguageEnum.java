package com._2lazy2name.notion.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LanguageEnum {
    ABAP("abap"),
    ARDUINO("arduino"),
    BASH("bash"),
    BASIC("basic"),
    C("c"),
    CLOJURE("clojure"),
    COFFEESCRIPT("coffeescript"),
    CPP("c++"),
    CS("c#"),
    CSS("css"),
    DART("dart"),
    DIFF("diff"),
    DOCKER("docker"),
    ELIXIR("elixir"),
    ELM("elm"),
    ERLANG("erlang"),
    FLOW("flow"),
    FORTRAN("fortran"),
    FSHARP("f#"),
    GHERKIN("gherkin"),
    GLSL("glsl"),
    GO("go"),
    GRAPHQL("graphql"),
    GROOVY("groovy"),
    HASKELL("haskell"),
    HTML("html"),
    JAVA("java"),
    JAVASCRIPT("javascript"),
    JSON("json"),
    JULIA("julia"),
    KOTLIN("kotlin"),
    LATEX("latex"),
    LESS("less"),
    LISP("lisp"),
    LIVESCRIPT("livescript"),
    LUA("lua"),
    MAKEFILE("makefile"),
    MARKDOWN("markdown"),
    MARKUP("markup"),
    MATLAB("matlab"),
    MERMAID("mermaid"),
    NIX("nix"),
    OBJECTIVE_C("objective-c"),
    OCAML("ocaml"),
    PASCAL("pascal"),
    PERL("perl"),
    PHP("php"),
    PLAIN_TEXT("plain text"),
    POWERSHELL("powershell"),
    PROLOG("prolog"),
    PROTOBUF("protobuf"),
    PYTHON("python"),
    R("r"),
    REASON("reason"),
    RUBY("ruby"),
    RUST("rust"),
    SASS("sass"),
    SCALA("scala"),
    SCHEME("scheme"),
    SCSS("scss"),
    SHELL("shell"),
    SQL("sql"),
    SWIFT("swift"),
    TYPESCRIPT("typescript"),
    VBNET("vb.net"),
    VERILOG("verilog"),
    VHDL("vhdl"),
    VISUAL_BASIC("visual basic"),
    WEBASSEMBLY("webassembly"),
    XML("xml"),
    YAML("yaml"),
    JAVACC("java/c/c++/c#");

    private final String language;

    @JsonCreator
    LanguageEnum(String language) {
        this.language = language;
    }

    @JsonValue
    public String toString() {
        return language;
    }

}
