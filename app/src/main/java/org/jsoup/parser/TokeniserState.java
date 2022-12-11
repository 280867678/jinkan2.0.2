package org.jsoup.parser;

import me.tvspark.outline;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.http.message.TokenParser;
import org.eclipse.jetty.util.B64Code;
import org.eclipse.jetty.util.MultiPartWriter;
import org.jsoup.nodes.DocumentType;
import org.jsoup.parser.Token;
import org.seamless.xml.DOM;

/* loaded from: classes5.dex */
public enum TokeniserState {
    Data { // from class: org.jsoup.parser.TokeniserState.1
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                tokeniser.emit(characterReader.consume());
                return;
            }
            if (current == '&') {
                tokeniserState = TokeniserState.CharacterReferenceInData;
            } else if (current != '<') {
                if (current != 65535) {
                    tokeniser.emit(characterReader.consumeData());
                    return;
                } else {
                    tokeniser.emit(new Token.EOF());
                    return;
                }
            } else {
                tokeniserState = TokeniserState.TagOpen;
            }
            tokeniser.advanceTransition(tokeniserState);
        }
    },
    CharacterReferenceInData { // from class: org.jsoup.parser.TokeniserState.2
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readCharRef(tokeniser, TokeniserState.Data);
        }
    },
    Rcdata { // from class: org.jsoup.parser.TokeniserState.3
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit((char) 65533);
                return;
            }
            if (current == '&') {
                tokeniserState = TokeniserState.CharacterReferenceInRcdata;
            } else if (current != '<') {
                if (current != 65535) {
                    tokeniser.emit(characterReader.consumeData());
                    return;
                } else {
                    tokeniser.emit(new Token.EOF());
                    return;
                }
            } else {
                tokeniserState = TokeniserState.RcdataLessthanSign;
            }
            tokeniser.advanceTransition(tokeniserState);
        }
    },
    CharacterReferenceInRcdata { // from class: org.jsoup.parser.TokeniserState.4
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readCharRef(tokeniser, TokeniserState.Rcdata);
        }
    },
    Rawtext { // from class: org.jsoup.parser.TokeniserState.5
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readRawData(tokeniser, characterReader, this, TokeniserState.RawtextLessthanSign);
        }
    },
    ScriptData { // from class: org.jsoup.parser.TokeniserState.6
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readRawData(tokeniser, characterReader, this, TokeniserState.ScriptDataLessthanSign);
        }
    },
    PLAINTEXT { // from class: org.jsoup.parser.TokeniserState.7
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit((char) 65533);
            } else if (current != 65535) {
                tokeniser.emit(characterReader.consumeTo((char) 0));
            } else {
                tokeniser.emit(new Token.EOF());
            }
        }
    },
    TagOpen { // from class: org.jsoup.parser.TokeniserState.8
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            TokeniserState tokeniserState2;
            char current = characterReader.current();
            if (current == '!') {
                tokeniserState = TokeniserState.MarkupDeclarationOpen;
            } else if (current == '/') {
                tokeniserState = TokeniserState.EndTagOpen;
            } else if (current != '?') {
                if (characterReader.matchesLetter()) {
                    tokeniser.createTagPending(true);
                    tokeniserState2 = TokeniserState.TagName;
                } else {
                    tokeniser.error(this);
                    tokeniser.emit('<');
                    tokeniserState2 = TokeniserState.Data;
                }
                tokeniser.transition(tokeniserState2);
                return;
            } else {
                tokeniser.createBogusCommentPending();
                tokeniserState = TokeniserState.BogusComment;
            }
            tokeniser.advanceTransition(tokeniserState);
        }
    },
    EndTagOpen { // from class: org.jsoup.parser.TokeniserState.9
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            TokeniserState tokeniserState2;
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.emit("</");
                tokeniserState2 = TokeniserState.Data;
            } else if (!characterReader.matchesLetter()) {
                boolean matches = characterReader.matches('>');
                tokeniser.error(this);
                if (matches) {
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniser.createBogusCommentPending();
                    tokeniserState = TokeniserState.BogusComment;
                }
                tokeniser.advanceTransition(tokeniserState);
                return;
            } else {
                tokeniser.createTagPending(false);
                tokeniserState2 = TokeniserState.TagName;
            }
            tokeniser.transition(tokeniserState2);
        }
    },
    TagName { // from class: org.jsoup.parser.TokeniserState.10
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            tokeniser.tagPending.appendTagName(characterReader.consumeTagName());
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.tagPending.appendTagName(TokeniserState.replacementStr);
                return;
            }
            if (consume != ' ') {
                if (consume != '/') {
                    if (consume == '<') {
                        characterReader.unconsume();
                        tokeniser.error(this);
                    } else if (consume != '>') {
                        if (consume == 65535) {
                            tokeniser.eofError(this);
                            tokeniserState = TokeniserState.Data;
                        } else if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                            tokeniser.tagPending.appendTagName(consume);
                            return;
                        }
                    }
                    tokeniser.emitTagPending();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.SelfClosingStartTag;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniserState = TokeniserState.BeforeAttributeName;
            tokeniser.transition(tokeniserState);
        }
    },
    RcdataLessthanSign { // from class: org.jsoup.parser.TokeniserState.11
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.matches('/')) {
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(TokeniserState.RCDATAEndTagOpen);
                return;
            }
            if (characterReader.matchesLetter() && tokeniser.appropriateEndTagName() != null) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("</");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(tokeniser.appropriateEndTagName());
                if (!characterReader.containsIgnoreCase(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString())) {
                    tokeniser.tagPending = tokeniser.createTagPending(false).name(tokeniser.appropriateEndTagName());
                    tokeniser.emitTagPending();
                    characterReader.unconsume();
                    tokeniserState = TokeniserState.Data;
                    tokeniser.transition(tokeniserState);
                }
            }
            tokeniser.emit("<");
            tokeniserState = TokeniserState.Rcdata;
            tokeniser.transition(tokeniserState);
        }
    },
    RCDATAEndTagOpen { // from class: org.jsoup.parser.TokeniserState.12
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.matchesLetter()) {
                tokeniser.emit("</");
                tokeniser.transition(TokeniserState.Rcdata);
                return;
            }
            tokeniser.createTagPending(false);
            tokeniser.tagPending.appendTagName(characterReader.current());
            tokeniser.dataBuffer.append(characterReader.current());
            tokeniser.advanceTransition(TokeniserState.RCDATAEndTagName);
        }
    },
    RCDATAEndTagName { // from class: org.jsoup.parser.TokeniserState.13
        private void anythingElse(Tokeniser tokeniser, CharacterReader characterReader) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("</");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(tokeniser.dataBuffer.toString());
            tokeniser.emit(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            characterReader.unconsume();
            tokeniser.transition(TokeniserState.Rcdata);
        }

        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.matchesLetter()) {
                String consumeLetterSequence = characterReader.consumeLetterSequence();
                tokeniser.tagPending.appendTagName(consumeLetterSequence);
                tokeniser.dataBuffer.append(consumeLetterSequence);
                return;
            }
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                if (tokeniser.isAppropriateEndTagToken()) {
                    tokeniserState = TokeniserState.BeforeAttributeName;
                    tokeniser.transition(tokeniserState);
                    return;
                }
                anythingElse(tokeniser, characterReader);
            } else if (consume == '/') {
                if (tokeniser.isAppropriateEndTagToken()) {
                    tokeniserState = TokeniserState.SelfClosingStartTag;
                    tokeniser.transition(tokeniserState);
                    return;
                }
                anythingElse(tokeniser, characterReader);
            } else {
                if (consume == '>' && tokeniser.isAppropriateEndTagToken()) {
                    tokeniser.emitTagPending();
                    tokeniserState = TokeniserState.Data;
                    tokeniser.transition(tokeniserState);
                    return;
                }
                anythingElse(tokeniser, characterReader);
            }
        }
    },
    RawtextLessthanSign { // from class: org.jsoup.parser.TokeniserState.14
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches('/')) {
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(TokeniserState.RawtextEndTagOpen);
                return;
            }
            tokeniser.emit('<');
            tokeniser.transition(TokeniserState.Rawtext);
        }
    },
    RawtextEndTagOpen { // from class: org.jsoup.parser.TokeniserState.15
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readEndTag(tokeniser, characterReader, TokeniserState.RawtextEndTagName, TokeniserState.Rawtext);
        }
    },
    RawtextEndTagName { // from class: org.jsoup.parser.TokeniserState.16
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, TokeniserState.Rawtext);
        }
    },
    ScriptDataLessthanSign { // from class: org.jsoup.parser.TokeniserState.17
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '!') {
                tokeniser.emit("<!");
                tokeniserState = TokeniserState.ScriptDataEscapeStart;
            } else if (consume != '/') {
                tokeniser.emit("<");
                if (consume != 65535) {
                    characterReader.unconsume();
                    tokeniserState = TokeniserState.ScriptData;
                } else {
                    tokeniser.eofError(this);
                    tokeniserState = TokeniserState.Data;
                }
            } else {
                tokeniser.createTempBuffer();
                tokeniserState = TokeniserState.ScriptDataEndTagOpen;
            }
            tokeniser.transition(tokeniserState);
        }
    },
    ScriptDataEndTagOpen { // from class: org.jsoup.parser.TokeniserState.18
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readEndTag(tokeniser, characterReader, TokeniserState.ScriptDataEndTagName, TokeniserState.ScriptData);
        }
    },
    ScriptDataEndTagName { // from class: org.jsoup.parser.TokeniserState.19
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, TokeniserState.ScriptData);
        }
    },
    ScriptDataEscapeStart { // from class: org.jsoup.parser.TokeniserState.20
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.matches('-')) {
                tokeniser.transition(TokeniserState.ScriptData);
                return;
            }
            tokeniser.emit('-');
            tokeniser.advanceTransition(TokeniserState.ScriptDataEscapeStartDash);
        }
    },
    ScriptDataEscapeStartDash { // from class: org.jsoup.parser.TokeniserState.21
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.matches('-')) {
                tokeniser.transition(TokeniserState.ScriptData);
                return;
            }
            tokeniser.emit('-');
            tokeniser.advanceTransition(TokeniserState.ScriptDataEscapedDashDash);
        }
    },
    ScriptDataEscaped { // from class: org.jsoup.parser.TokeniserState.22
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit((char) 65533);
                return;
            }
            if (current == '-') {
                tokeniser.emit('-');
                tokeniserState = TokeniserState.ScriptDataEscapedDash;
            } else if (current != '<') {
                tokeniser.emit(characterReader.consumeToAny('-', '<', 0));
                return;
            } else {
                tokeniserState = TokeniserState.ScriptDataEscapedLessthanSign;
            }
            tokeniser.advanceTransition(tokeniserState);
        }
    },
    ScriptDataEscapedDash { // from class: org.jsoup.parser.TokeniserState.23
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume == '-') {
                    tokeniser.emit(consume);
                    tokeniserState = TokeniserState.ScriptDataEscapedDashDash;
                } else if (consume == '<') {
                    tokeniserState = TokeniserState.ScriptDataEscapedLessthanSign;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniser.error(this);
            consume = 65533;
            tokeniser.emit(consume);
            tokeniserState = TokeniserState.ScriptDataEscaped;
            tokeniser.transition(tokeniserState);
        }
    },
    ScriptDataEscapedDashDash { // from class: org.jsoup.parser.TokeniserState.24
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume == '-') {
                    tokeniser.emit(consume);
                    return;
                }
                if (consume != '<') {
                    tokeniser.emit(consume);
                    if (consume == '>') {
                        tokeniserState = TokeniserState.ScriptData;
                    }
                } else {
                    tokeniserState = TokeniserState.ScriptDataEscapedLessthanSign;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniser.error(this);
            tokeniser.emit((char) 65533);
            tokeniserState = TokeniserState.ScriptDataEscaped;
            tokeniser.transition(tokeniserState);
        }
    },
    ScriptDataEscapedLessthanSign { // from class: org.jsoup.parser.TokeniserState.25
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.matchesLetter()) {
                tokeniser.createTempBuffer();
                tokeniser.dataBuffer.append(characterReader.current());
                tokeniser.emit("<" + characterReader.current());
                tokeniserState = TokeniserState.ScriptDataDoubleEscapeStart;
            } else if (!characterReader.matches('/')) {
                tokeniser.emit('<');
                tokeniser.transition(TokeniserState.ScriptDataEscaped);
                return;
            } else {
                tokeniser.createTempBuffer();
                tokeniserState = TokeniserState.ScriptDataEscapedEndTagOpen;
            }
            tokeniser.advanceTransition(tokeniserState);
        }
    },
    ScriptDataEscapedEndTagOpen { // from class: org.jsoup.parser.TokeniserState.26
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.matchesLetter()) {
                tokeniser.emit("</");
                tokeniser.transition(TokeniserState.ScriptDataEscaped);
                return;
            }
            tokeniser.createTagPending(false);
            tokeniser.tagPending.appendTagName(characterReader.current());
            tokeniser.dataBuffer.append(characterReader.current());
            tokeniser.advanceTransition(TokeniserState.ScriptDataEscapedEndTagName);
        }
    },
    ScriptDataEscapedEndTagName { // from class: org.jsoup.parser.TokeniserState.27
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscapeStart { // from class: org.jsoup.parser.TokeniserState.28
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataDoubleEscapeTag(tokeniser, characterReader, TokeniserState.ScriptDataDoubleEscaped, TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscaped { // from class: org.jsoup.parser.TokeniserState.29
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit((char) 65533);
                return;
            }
            if (current == '-') {
                tokeniser.emit(current);
                tokeniserState = TokeniserState.ScriptDataDoubleEscapedDash;
            } else if (current != '<') {
                if (current != 65535) {
                    tokeniser.emit(characterReader.consumeToAny('-', '<', 0));
                    return;
                }
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
                return;
            } else {
                tokeniser.emit(current);
                tokeniserState = TokeniserState.ScriptDataDoubleEscapedLessthanSign;
            }
            tokeniser.advanceTransition(tokeniserState);
        }
    },
    ScriptDataDoubleEscapedDash { // from class: org.jsoup.parser.TokeniserState.30
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume == '-') {
                    tokeniser.emit(consume);
                    tokeniserState = TokeniserState.ScriptDataDoubleEscapedDashDash;
                } else if (consume == '<') {
                    tokeniser.emit(consume);
                    tokeniserState = TokeniserState.ScriptDataDoubleEscapedLessthanSign;
                } else if (consume == 65535) {
                    tokeniser.eofError(this);
                    tokeniserState = TokeniserState.Data;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniser.error(this);
            consume = 65533;
            tokeniser.emit(consume);
            tokeniserState = TokeniserState.ScriptDataDoubleEscaped;
            tokeniser.transition(tokeniserState);
        }
    },
    ScriptDataDoubleEscapedDashDash { // from class: org.jsoup.parser.TokeniserState.31
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume == '-') {
                    tokeniser.emit(consume);
                    return;
                }
                if (consume == '<') {
                    tokeniser.emit(consume);
                    tokeniserState = TokeniserState.ScriptDataDoubleEscapedLessthanSign;
                } else if (consume == '>') {
                    tokeniser.emit(consume);
                    tokeniserState = TokeniserState.ScriptData;
                } else if (consume == 65535) {
                    tokeniser.eofError(this);
                    tokeniserState = TokeniserState.Data;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniser.error(this);
            consume = 65533;
            tokeniser.emit(consume);
            tokeniserState = TokeniserState.ScriptDataDoubleEscaped;
            tokeniser.transition(tokeniserState);
        }
    },
    ScriptDataDoubleEscapedLessthanSign { // from class: org.jsoup.parser.TokeniserState.32
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.matches('/')) {
                tokeniser.transition(TokeniserState.ScriptDataDoubleEscaped);
                return;
            }
            tokeniser.emit('/');
            tokeniser.createTempBuffer();
            tokeniser.advanceTransition(TokeniserState.ScriptDataDoubleEscapeEnd);
        }
    },
    ScriptDataDoubleEscapeEnd { // from class: org.jsoup.parser.TokeniserState.33
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataDoubleEscapeTag(tokeniser, characterReader, TokeniserState.ScriptDataEscaped, TokeniserState.ScriptDataDoubleEscaped);
        }
    },
    BeforeAttributeName { // from class: org.jsoup.parser.TokeniserState.34
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == 0) {
                characterReader.unconsume();
                tokeniser.error(this);
                tokeniser.tagPending.newAttribute();
            } else if (consume == ' ') {
                return;
            } else {
                if (consume != '\"' && consume != '\'') {
                    if (consume != '/') {
                        if (consume == 65535) {
                            tokeniser.eofError(this);
                        } else if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                            switch (consume) {
                                case '<':
                                    characterReader.unconsume();
                                    tokeniser.error(this);
                                    tokeniser.emitTagPending();
                                    break;
                                case '=':
                                    break;
                                case '>':
                                    tokeniser.emitTagPending();
                                    break;
                                default:
                                    tokeniser.tagPending.newAttribute();
                                    characterReader.unconsume();
                                    break;
                            }
                        } else {
                            return;
                        }
                        tokeniserState = TokeniserState.Data;
                    } else {
                        tokeniserState = TokeniserState.SelfClosingStartTag;
                    }
                    tokeniser.transition(tokeniserState);
                }
                tokeniser.error(this);
                tokeniser.tagPending.newAttribute();
                tokeniser.tagPending.appendAttributeName(consume);
            }
            tokeniserState = TokeniserState.AttributeName;
            tokeniser.transition(tokeniserState);
        }
    },
    AttributeName { // from class: org.jsoup.parser.TokeniserState.35
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            Token.Tag tag;
            TokeniserState tokeniserState;
            tokeniser.tagPending.appendAttributeName(characterReader.consumeToAnySorted(TokeniserState.attributeNameCharsSorted));
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != ' ') {
                    if (consume != '\"' && consume != '\'') {
                        if (consume != '/') {
                            if (consume == 65535) {
                                tokeniser.eofError(this);
                            } else if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                                switch (consume) {
                                    case '<':
                                        break;
                                    case '=':
                                        tokeniserState = TokeniserState.BeforeAttributeValue;
                                        break;
                                    case '>':
                                        tokeniser.emitTagPending();
                                        break;
                                    default:
                                        tag = tokeniser.tagPending;
                                        break;
                                }
                            }
                            tokeniserState = TokeniserState.Data;
                        } else {
                            tokeniserState = TokeniserState.SelfClosingStartTag;
                        }
                        tokeniser.transition(tokeniserState);
                        return;
                    }
                    tokeniser.error(this);
                    tag = tokeniser.tagPending;
                }
                tokeniserState = TokeniserState.AfterAttributeName;
                tokeniser.transition(tokeniserState);
                return;
            }
            tokeniser.error(this);
            tag = tokeniser.tagPending;
            consume = 65533;
            tag.appendAttributeName(consume);
        }
    },
    AfterAttributeName { // from class: org.jsoup.parser.TokeniserState.36
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            Token.Tag tag;
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tag = tokeniser.tagPending;
                consume = 65533;
            } else if (consume == ' ') {
                return;
            } else {
                if (consume != '\"' && consume != '\'') {
                    if (consume != '/') {
                        if (consume == 65535) {
                            tokeniser.eofError(this);
                        } else if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                            switch (consume) {
                                case '<':
                                    break;
                                case '=':
                                    tokeniserState = TokeniserState.BeforeAttributeValue;
                                    break;
                                case '>':
                                    tokeniser.emitTagPending();
                                    break;
                                default:
                                    tokeniser.tagPending.newAttribute();
                                    characterReader.unconsume();
                                    tokeniserState = TokeniserState.AttributeName;
                                    break;
                            }
                        } else {
                            return;
                        }
                        tokeniserState = TokeniserState.Data;
                    } else {
                        tokeniserState = TokeniserState.SelfClosingStartTag;
                    }
                    tokeniser.transition(tokeniserState);
                }
                tokeniser.error(this);
                tokeniser.tagPending.newAttribute();
                tag = tokeniser.tagPending;
            }
            tag.appendAttributeName(consume);
            tokeniserState = TokeniserState.AttributeName;
            tokeniser.transition(tokeniserState);
        }
    },
    BeforeAttributeValue { // from class: org.jsoup.parser.TokeniserState.37
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            Token.Tag tag;
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume == ' ') {
                    return;
                }
                if (consume != '\"') {
                    if (consume != '`') {
                        if (consume == 65535) {
                            tokeniser.eofError(this);
                        } else if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r') {
                            return;
                        } else {
                            if (consume != '&') {
                                if (consume != '\'') {
                                    switch (consume) {
                                        case '>':
                                            tokeniser.error(this);
                                            break;
                                    }
                                } else {
                                    tokeniserState = TokeniserState.AttributeValue_singleQuoted;
                                }
                            }
                            characterReader.unconsume();
                            tokeniserState = TokeniserState.AttributeValue_unquoted;
                        }
                        tokeniser.emitTagPending();
                        tokeniserState = TokeniserState.Data;
                    }
                    tokeniser.error(this);
                    tag = tokeniser.tagPending;
                } else {
                    tokeniserState = TokeniserState.AttributeValue_doubleQuoted;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniser.error(this);
            tag = tokeniser.tagPending;
            consume = 65533;
            tag.appendAttributeValue(consume);
            tokeniserState = TokeniserState.AttributeValue_unquoted;
            tokeniser.transition(tokeniserState);
        }
    },
    AttributeValue_doubleQuoted { // from class: org.jsoup.parser.TokeniserState.38
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            Token.Tag tag;
            TokeniserState tokeniserState;
            String consumeToAnySorted = characterReader.consumeToAnySorted(TokeniserState.attributeDoubleValueCharsSorted);
            if (consumeToAnySorted.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(consumeToAnySorted);
            } else {
                tokeniser.tagPending.setEmptyAttributeValue();
            }
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume == '\"') {
                    tokeniserState = TokeniserState.AfterAttributeValue_quoted;
                } else if (consume == '&') {
                    int[] consumeCharacterReference = tokeniser.consumeCharacterReference('\"', true);
                    Token.Tag tag2 = tokeniser.tagPending;
                    if (consumeCharacterReference != null) {
                        tag2.appendAttributeValue(consumeCharacterReference);
                        return;
                    } else {
                        tag2.appendAttributeValue('&');
                        return;
                    }
                } else if (consume != 65535) {
                    tag = tokeniser.tagPending;
                } else {
                    tokeniser.eofError(this);
                    tokeniserState = TokeniserState.Data;
                }
                tokeniser.transition(tokeniserState);
                return;
            }
            tokeniser.error(this);
            tag = tokeniser.tagPending;
            consume = 65533;
            tag.appendAttributeValue(consume);
        }
    },
    AttributeValue_singleQuoted { // from class: org.jsoup.parser.TokeniserState.39
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            Token.Tag tag;
            TokeniserState tokeniserState;
            String consumeToAnySorted = characterReader.consumeToAnySorted(TokeniserState.attributeSingleValueCharsSorted);
            if (consumeToAnySorted.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(consumeToAnySorted);
            } else {
                tokeniser.tagPending.setEmptyAttributeValue();
            }
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume == 65535) {
                    tokeniser.eofError(this);
                    tokeniserState = TokeniserState.Data;
                } else if (consume == '&') {
                    int[] consumeCharacterReference = tokeniser.consumeCharacterReference(Character.valueOf(ExtendedMessageFormat.QUOTE), true);
                    Token.Tag tag2 = tokeniser.tagPending;
                    if (consumeCharacterReference != null) {
                        tag2.appendAttributeValue(consumeCharacterReference);
                        return;
                    } else {
                        tag2.appendAttributeValue('&');
                        return;
                    }
                } else if (consume != '\'') {
                    tag = tokeniser.tagPending;
                } else {
                    tokeniserState = TokeniserState.AfterAttributeValue_quoted;
                }
                tokeniser.transition(tokeniserState);
                return;
            }
            tokeniser.error(this);
            tag = tokeniser.tagPending;
            consume = 65533;
            tag.appendAttributeValue(consume);
        }
    },
    AttributeValue_unquoted { // from class: org.jsoup.parser.TokeniserState.40
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            Token.Tag tag;
            TokeniserState tokeniserState;
            String consumeToAnySorted = characterReader.consumeToAnySorted(TokeniserState.attributeValueUnquoted);
            if (consumeToAnySorted.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(consumeToAnySorted);
            }
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != ' ') {
                    if (consume != '\"' && consume != '`') {
                        if (consume == 65535) {
                            tokeniser.eofError(this);
                        } else if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                            if (consume == '&') {
                                int[] consumeCharacterReference = tokeniser.consumeCharacterReference('>', true);
                                Token.Tag tag2 = tokeniser.tagPending;
                                if (consumeCharacterReference != null) {
                                    tag2.appendAttributeValue(consumeCharacterReference);
                                    return;
                                } else {
                                    tag2.appendAttributeValue('&');
                                    return;
                                }
                            } else if (consume != '\'') {
                                switch (consume) {
                                    case '>':
                                        tokeniser.emitTagPending();
                                        break;
                                    case '<':
                                    case '=':
                                        tokeniser.error(this);
                                        break;
                                }
                                tag = tokeniser.tagPending;
                            }
                        }
                        tokeniserState = TokeniserState.Data;
                        tokeniser.transition(tokeniserState);
                        return;
                    }
                    tokeniser.error(this);
                    tag = tokeniser.tagPending;
                }
                tokeniserState = TokeniserState.BeforeAttributeName;
                tokeniser.transition(tokeniserState);
                return;
            }
            tokeniser.error(this);
            tag = tokeniser.tagPending;
            consume = 65533;
            tag.appendAttributeValue(consume);
        }
    },
    AfterAttributeValue_quoted { // from class: org.jsoup.parser.TokeniserState.41
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r' && consume != ' ') {
                if (consume != '/') {
                    if (consume == '>') {
                        tokeniser.emitTagPending();
                    } else if (consume != 65535) {
                        characterReader.unconsume();
                        tokeniser.error(this);
                    } else {
                        tokeniser.eofError(this);
                    }
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.SelfClosingStartTag;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniserState = TokeniserState.BeforeAttributeName;
            tokeniser.transition(tokeniserState);
        }
    },
    SelfClosingStartTag { // from class: org.jsoup.parser.TokeniserState.42
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '>') {
                tokeniser.tagPending.selfClosing = true;
                tokeniser.emitTagPending();
            } else if (consume != 65535) {
                characterReader.unconsume();
                tokeniser.error(this);
                tokeniserState = TokeniserState.BeforeAttributeName;
                tokeniser.transition(tokeniserState);
            } else {
                tokeniser.eofError(this);
            }
            tokeniserState = TokeniserState.Data;
            tokeniser.transition(tokeniserState);
        }
    },
    BogusComment { // from class: org.jsoup.parser.TokeniserState.43
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            characterReader.unconsume();
            tokeniser.commentPending.append(characterReader.consumeTo('>'));
            char consume = characterReader.consume();
            if (consume == '>' || consume == 65535) {
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    MarkupDeclarationOpen { // from class: org.jsoup.parser.TokeniserState.44
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.matchConsume(MultiPartWriter.__DASHDASH)) {
                tokeniser.createCommentPending();
                tokeniserState = TokeniserState.CommentStart;
            } else if (characterReader.matchConsumeIgnoreCase("DOCTYPE")) {
                tokeniserState = TokeniserState.Doctype;
            } else if (!characterReader.matchConsume("[CDATA[")) {
                tokeniser.error(this);
                tokeniser.createBogusCommentPending();
                tokeniser.advanceTransition(TokeniserState.BogusComment);
                return;
            } else {
                tokeniser.createTempBuffer();
                tokeniserState = TokeniserState.CdataSection;
            }
            tokeniser.transition(tokeniserState);
        }
    },
    CommentStart { // from class: org.jsoup.parser.TokeniserState.45
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != '-') {
                    if (consume == '>') {
                        tokeniser.error(this);
                    } else if (consume != 65535) {
                        characterReader.unconsume();
                    } else {
                        tokeniser.eofError(this);
                    }
                    tokeniser.emitCommentPending();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.CommentStartDash;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniser.error(this);
            tokeniser.commentPending.append((char) 65533);
            tokeniserState = TokeniserState.Comment;
            tokeniser.transition(tokeniserState);
        }
    },
    CommentStartDash { // from class: org.jsoup.parser.TokeniserState.46
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != '-') {
                    if (consume == '>') {
                        tokeniser.error(this);
                    } else if (consume != 65535) {
                        tokeniser.commentPending.append(consume);
                    } else {
                        tokeniser.eofError(this);
                    }
                    tokeniser.emitCommentPending();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.CommentStartDash;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniser.error(this);
            tokeniser.commentPending.append((char) 65533);
            tokeniserState = TokeniserState.Comment;
            tokeniser.transition(tokeniserState);
        }
    },
    Comment { // from class: org.jsoup.parser.TokeniserState.47
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.commentPending.append((char) 65533);
            } else if (current == '-') {
                tokeniser.advanceTransition(TokeniserState.CommentEndDash);
            } else if (current != 65535) {
                tokeniser.commentPending.append(characterReader.consumeToAny('-', 0));
            } else {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    CommentEndDash { // from class: org.jsoup.parser.TokeniserState.48
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume == '-') {
                    tokeniserState = TokeniserState.CommentEnd;
                } else if (consume != 65535) {
                    tokeniser.commentPending.append('-').append(consume);
                } else {
                    tokeniser.eofError(this);
                    tokeniser.emitCommentPending();
                    tokeniserState = TokeniserState.Data;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniser.error(this);
            tokeniser.commentPending.append('-').append((char) 65533);
            tokeniserState = TokeniserState.Comment;
            tokeniser.transition(tokeniserState);
        }
    },
    CommentEnd { // from class: org.jsoup.parser.TokeniserState.49
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume == '!') {
                    tokeniser.error(this);
                    tokeniserState = TokeniserState.CommentEndBang;
                } else if (consume == '-') {
                    tokeniser.error(this);
                    tokeniser.commentPending.append('-');
                    return;
                } else {
                    if (consume != '>') {
                        if (consume != 65535) {
                            tokeniser.error(this);
                            tokeniser.commentPending.append(MultiPartWriter.__DASHDASH).append(consume);
                        } else {
                            tokeniser.eofError(this);
                        }
                    }
                    tokeniser.emitCommentPending();
                    tokeniserState = TokeniserState.Data;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniser.error(this);
            tokeniser.commentPending.append(MultiPartWriter.__DASHDASH).append((char) 65533);
            tokeniserState = TokeniserState.Comment;
            tokeniser.transition(tokeniserState);
        }
    },
    CommentEndBang { // from class: org.jsoup.parser.TokeniserState.50
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != '-') {
                    if (consume != '>') {
                        if (consume != 65535) {
                            tokeniser.commentPending.append("--!").append(consume);
                        } else {
                            tokeniser.eofError(this);
                        }
                    }
                    tokeniser.emitCommentPending();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniser.commentPending.append("--!");
                    tokeniserState = TokeniserState.CommentEndDash;
                }
                tokeniser.transition(tokeniserState);
            }
            tokeniser.error(this);
            tokeniser.commentPending.append("--!").append((char) 65533);
            tokeniserState = TokeniserState.Comment;
            tokeniser.transition(tokeniserState);
        }
    },
    Doctype { // from class: org.jsoup.parser.TokeniserState.51
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r' && consume != ' ') {
                if (consume != '>') {
                    if (consume != 65535) {
                        tokeniser.error(this);
                    } else {
                        tokeniser.eofError(this);
                    }
                }
                tokeniser.error(this);
                tokeniser.createDoctypePending();
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniserState = TokeniserState.Data;
                tokeniser.transition(tokeniserState);
            }
            tokeniserState = TokeniserState.BeforeDoctypeName;
            tokeniser.transition(tokeniserState);
        }
    },
    BeforeDoctypeName { // from class: org.jsoup.parser.TokeniserState.52
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.matchesLetter()) {
                tokeniser.createDoctypePending();
                tokeniser.transition(TokeniserState.DoctypeName);
                return;
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.createDoctypePending();
                tokeniser.doctypePending.name.append((char) 65533);
            } else if (consume == ' ') {
                return;
            } else {
                if (consume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.createDoctypePending();
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniserState = TokeniserState.Data;
                    tokeniser.transition(tokeniserState);
                } else if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r') {
                    return;
                } else {
                    tokeniser.createDoctypePending();
                    tokeniser.doctypePending.name.append(consume);
                }
            }
            tokeniserState = TokeniserState.DoctypeName;
            tokeniser.transition(tokeniserState);
        }
    },
    DoctypeName { // from class: org.jsoup.parser.TokeniserState.53
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            if (characterReader.matchesLetter()) {
                tokeniser.doctypePending.name.append(characterReader.consumeLetterSequence());
                return;
            }
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != ' ') {
                    if (consume != '>') {
                        if (consume == 65535) {
                            tokeniser.eofError(this);
                            tokeniser.doctypePending.forceQuirks = true;
                        } else if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                            sb = tokeniser.doctypePending.name;
                        }
                    }
                    tokeniser.emitDoctypePending();
                    tokeniserState = TokeniserState.Data;
                    tokeniser.transition(tokeniserState);
                    return;
                }
                tokeniserState = TokeniserState.AfterDoctypeName;
                tokeniser.transition(tokeniserState);
                return;
            }
            tokeniser.error(this);
            sb = tokeniser.doctypePending.name;
            consume = 65533;
            sb.append(consume);
        }
    },
    AfterDoctypeName { // from class: org.jsoup.parser.TokeniserState.54
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            TokeniserState tokeniserState2;
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            } else if (characterReader.matchesAny('\t', '\n', '\r', '\f', TokenParser.f4579SP)) {
                characterReader.advance();
            } else {
                if (!characterReader.matches('>')) {
                    if (characterReader.matchConsumeIgnoreCase(DocumentType.PUBLIC_KEY)) {
                        tokeniser.doctypePending.pubSysKey = DocumentType.PUBLIC_KEY;
                        tokeniserState2 = TokeniserState.AfterDoctypePublicKeyword;
                    } else if (characterReader.matchConsumeIgnoreCase(DocumentType.SYSTEM_KEY)) {
                        tokeniser.doctypePending.pubSysKey = DocumentType.SYSTEM_KEY;
                        tokeniserState2 = TokeniserState.AfterDoctypeSystemKeyword;
                    } else {
                        tokeniser.error(this);
                        tokeniser.doctypePending.forceQuirks = true;
                        tokeniserState = TokeniserState.BogusDoctype;
                    }
                    tokeniser.transition(tokeniserState2);
                    return;
                }
                tokeniser.emitDoctypePending();
                tokeniserState = TokeniserState.Data;
                tokeniser.advanceTransition(tokeniserState);
            }
        }
    },
    AfterDoctypePublicKeyword { // from class: org.jsoup.parser.TokeniserState.55
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniserState = TokeniserState.BeforeDoctypePublicIdentifier;
            } else if (consume == '\"') {
                tokeniser.error(this);
                tokeniserState = TokeniserState.DoctypePublicIdentifier_doubleQuoted;
            } else if (consume != '\'') {
                if (consume == '>') {
                    tokeniser.error(this);
                } else if (consume != 65535) {
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniserState = TokeniserState.BogusDoctype;
                } else {
                    tokeniser.eofError(this);
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniserState = TokeniserState.Data;
            } else {
                tokeniser.error(this);
                tokeniserState = TokeniserState.DoctypePublicIdentifier_singleQuoted;
            }
            tokeniser.transition(tokeniserState);
        }
    },
    BeforeDoctypePublicIdentifier { // from class: org.jsoup.parser.TokeniserState.56
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume == '\"') {
                tokeniserState = TokeniserState.DoctypePublicIdentifier_doubleQuoted;
            } else if (consume != '\'') {
                if (consume == '>') {
                    tokeniser.error(this);
                } else if (consume != 65535) {
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniserState = TokeniserState.BogusDoctype;
                } else {
                    tokeniser.eofError(this);
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniserState = TokeniserState.Data;
            } else {
                tokeniserState = TokeniserState.DoctypePublicIdentifier_singleQuoted;
            }
            tokeniser.transition(tokeniserState);
        }
    },
    DoctypePublicIdentifier_doubleQuoted { // from class: org.jsoup.parser.TokeniserState.57
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != '\"') {
                    if (consume == '>') {
                        tokeniser.error(this);
                    } else if (consume != 65535) {
                        sb = tokeniser.doctypePending.publicIdentifier;
                    } else {
                        tokeniser.eofError(this);
                    }
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.AfterDoctypePublicIdentifier;
                }
                tokeniser.transition(tokeniserState);
                return;
            }
            tokeniser.error(this);
            sb = tokeniser.doctypePending.publicIdentifier;
            consume = 65533;
            sb.append(consume);
        }
    },
    DoctypePublicIdentifier_singleQuoted { // from class: org.jsoup.parser.TokeniserState.58
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != '\'') {
                    if (consume == '>') {
                        tokeniser.error(this);
                    } else if (consume != 65535) {
                        sb = tokeniser.doctypePending.publicIdentifier;
                    } else {
                        tokeniser.eofError(this);
                    }
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.AfterDoctypePublicIdentifier;
                }
                tokeniser.transition(tokeniserState);
                return;
            }
            tokeniser.error(this);
            sb = tokeniser.doctypePending.publicIdentifier;
            consume = 65533;
            sb.append(consume);
        }
    },
    AfterDoctypePublicIdentifier { // from class: org.jsoup.parser.TokeniserState.59
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniserState = TokeniserState.BetweenDoctypePublicAndSystemIdentifiers;
            } else if (consume == '\"') {
                tokeniser.error(this);
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_doubleQuoted;
            } else if (consume != '\'') {
                if (consume != '>') {
                    if (consume != 65535) {
                        tokeniser.error(this);
                        tokeniser.doctypePending.forceQuirks = true;
                        tokeniserState = TokeniserState.BogusDoctype;
                    } else {
                        tokeniser.eofError(this);
                        tokeniser.doctypePending.forceQuirks = true;
                    }
                }
                tokeniser.emitDoctypePending();
                tokeniserState = TokeniserState.Data;
            } else {
                tokeniser.error(this);
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_singleQuoted;
            }
            tokeniser.transition(tokeniserState);
        }
    },
    BetweenDoctypePublicAndSystemIdentifiers { // from class: org.jsoup.parser.TokeniserState.60
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume == '\"') {
                tokeniser.error(this);
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_doubleQuoted;
            } else if (consume != '\'') {
                if (consume != '>') {
                    if (consume != 65535) {
                        tokeniser.error(this);
                        tokeniser.doctypePending.forceQuirks = true;
                        tokeniserState = TokeniserState.BogusDoctype;
                    } else {
                        tokeniser.eofError(this);
                        tokeniser.doctypePending.forceQuirks = true;
                    }
                }
                tokeniser.emitDoctypePending();
                tokeniserState = TokeniserState.Data;
            } else {
                tokeniser.error(this);
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_singleQuoted;
            }
            tokeniser.transition(tokeniserState);
        }
    },
    AfterDoctypeSystemKeyword { // from class: org.jsoup.parser.TokeniserState.61
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniserState = TokeniserState.BeforeDoctypeSystemIdentifier;
            } else if (consume == '\"') {
                tokeniser.error(this);
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_doubleQuoted;
            } else if (consume != '\'') {
                if (consume == '>') {
                    tokeniser.error(this);
                } else if (consume != 65535) {
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    return;
                } else {
                    tokeniser.eofError(this);
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniserState = TokeniserState.Data;
            } else {
                tokeniser.error(this);
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_singleQuoted;
            }
            tokeniser.transition(tokeniserState);
        }
    },
    BeforeDoctypeSystemIdentifier { // from class: org.jsoup.parser.TokeniserState.62
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume == '\"') {
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_doubleQuoted;
            } else if (consume != '\'') {
                if (consume == '>') {
                    tokeniser.error(this);
                } else if (consume != 65535) {
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniserState = TokeniserState.BogusDoctype;
                } else {
                    tokeniser.eofError(this);
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniserState = TokeniserState.Data;
            } else {
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_singleQuoted;
            }
            tokeniser.transition(tokeniserState);
        }
    },
    DoctypeSystemIdentifier_doubleQuoted { // from class: org.jsoup.parser.TokeniserState.63
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != '\"') {
                    if (consume == '>') {
                        tokeniser.error(this);
                    } else if (consume != 65535) {
                        sb = tokeniser.doctypePending.systemIdentifier;
                    } else {
                        tokeniser.eofError(this);
                    }
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.AfterDoctypeSystemIdentifier;
                }
                tokeniser.transition(tokeniserState);
                return;
            }
            tokeniser.error(this);
            sb = tokeniser.doctypePending.systemIdentifier;
            consume = 65533;
            sb.append(consume);
        }
    },
    DoctypeSystemIdentifier_singleQuoted { // from class: org.jsoup.parser.TokeniserState.64
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume != 0) {
                if (consume != '\'') {
                    if (consume == '>') {
                        tokeniser.error(this);
                    } else if (consume != 65535) {
                        sb = tokeniser.doctypePending.systemIdentifier;
                    } else {
                        tokeniser.eofError(this);
                    }
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.AfterDoctypeSystemIdentifier;
                }
                tokeniser.transition(tokeniserState);
                return;
            }
            tokeniser.error(this);
            sb = tokeniser.doctypePending.systemIdentifier;
            consume = 65533;
            sb.append(consume);
        }
    },
    AfterDoctypeSystemIdentifier { // from class: org.jsoup.parser.TokeniserState.65
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume != '>') {
                if (consume != 65535) {
                    tokeniser.error(this);
                    tokeniserState = TokeniserState.BogusDoctype;
                    tokeniser.transition(tokeniserState);
                }
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
            }
            tokeniser.emitDoctypePending();
            tokeniserState = TokeniserState.Data;
            tokeniser.transition(tokeniserState);
        }
    },
    BogusDoctype { // from class: org.jsoup.parser.TokeniserState.66
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '>' || consume == 65535) {
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    CdataSection { // from class: org.jsoup.parser.TokeniserState.67
        @Override // org.jsoup.parser.TokeniserState
        public void read(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.dataBuffer.append(characterReader.consumeTo(DOM.CDATA_END));
            if (characterReader.matchConsume(DOM.CDATA_END) || characterReader.isEmpty()) {
                tokeniser.emit(new Token.CData(tokeniser.dataBuffer.toString()));
                tokeniser.transition(TokeniserState.Data);
            }
        }
    };
    
    public static final char eof = 65535;
    public static final char nullChar = 0;
    public static final char replacementChar = 65533;
    public static final char[] attributeSingleValueCharsSorted = {0, '&', ExtendedMessageFormat.QUOTE};
    public static final char[] attributeDoubleValueCharsSorted = {0, '\"', '&'};
    public static final char[] attributeNameCharsSorted = {0, '\t', '\n', '\f', '\r', TokenParser.f4579SP, '\"', ExtendedMessageFormat.QUOTE, '/', '<', B64Code.__pad, '>'};
    public static final char[] attributeValueUnquoted = {0, '\t', '\n', '\f', '\r', TokenParser.f4579SP, '\"', '&', ExtendedMessageFormat.QUOTE, '<', B64Code.__pad, '>', '`'};
    public static final String replacementStr = String.valueOf((char) 65533);

    public static void handleDataDoubleEscapeTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.matchesLetter()) {
            String consumeLetterSequence = characterReader.consumeLetterSequence();
            tokeniser.dataBuffer.append(consumeLetterSequence);
            tokeniser.emit(consumeLetterSequence);
            return;
        }
        char consume = characterReader.consume();
        if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r' && consume != ' ' && consume != '/' && consume != '>') {
            characterReader.unconsume();
            tokeniser.transition(tokeniserState2);
            return;
        }
        if (tokeniser.dataBuffer.toString().equals("script")) {
            tokeniser.transition(tokeniserState);
        } else {
            tokeniser.transition(tokeniserState2);
        }
        tokeniser.emit(consume);
    }

    public static void handleDataEndTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState) {
        TokeniserState tokeniserState2;
        if (characterReader.matchesLetter()) {
            String consumeLetterSequence = characterReader.consumeLetterSequence();
            tokeniser.tagPending.appendTagName(consumeLetterSequence);
            tokeniser.dataBuffer.append(consumeLetterSequence);
            return;
        }
        boolean z = false;
        boolean z2 = true;
        if (tokeniser.isAppropriateEndTagToken() && !characterReader.isEmpty()) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniserState2 = BeforeAttributeName;
            } else if (consume == '/') {
                tokeniserState2 = SelfClosingStartTag;
            } else if (consume != '>') {
                tokeniser.dataBuffer.append(consume);
                z = true;
                z2 = z;
            } else {
                tokeniser.emitTagPending();
                tokeniserState2 = Data;
            }
            tokeniser.transition(tokeniserState2);
            z2 = z;
        }
        if (!z2) {
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("</");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(tokeniser.dataBuffer.toString());
        tokeniser.emit(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        tokeniser.transition(tokeniserState);
    }

    public static void readCharRef(Tokeniser tokeniser, TokeniserState tokeniserState) {
        int[] consumeCharacterReference = tokeniser.consumeCharacterReference(null, false);
        if (consumeCharacterReference == null) {
            tokeniser.emit('&');
        } else {
            tokeniser.emit(consumeCharacterReference);
        }
        tokeniser.transition(tokeniserState);
    }

    public static void readEndTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.matchesLetter()) {
            tokeniser.createTagPending(false);
            tokeniser.transition(tokeniserState);
            return;
        }
        tokeniser.emit("</");
        tokeniser.transition(tokeniserState2);
    }

    public static void readRawData(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        char current = characterReader.current();
        if (current == 0) {
            tokeniser.error(tokeniserState);
            characterReader.advance();
            tokeniser.emit((char) 65533);
        } else if (current == '<') {
            tokeniser.advanceTransition(tokeniserState2);
        } else if (current != 65535) {
            tokeniser.emit(characterReader.consumeRawData());
        } else {
            tokeniser.emit(new Token.EOF());
        }
    }

    public abstract void read(Tokeniser tokeniser, CharacterReader characterReader);
}
