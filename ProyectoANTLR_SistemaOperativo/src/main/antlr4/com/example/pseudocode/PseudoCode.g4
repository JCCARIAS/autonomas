grammar PseudoCode;

program     : funcion+ EOF ;
funcion     : FUNCION PARAMS_OPEN parametros PARAMS_CLOSE codigo FUNCION_CLOSE ;
parametros  : (IDENT | NUM) (',' (IDENT | NUM))* ;
codigo      : CODIGO_OPEN (asignacion | estructura)* CODIGO_CLOSE ;
estructura  : ifEstructura | doEstructura ;
ifEstructura: IF_OPEN condicion CODIGO_OPEN asignacion CODIGO_CLOSE IF_CLOSE ;
doEstructura: DO_OPEN CODIGO_OPEN asignacion CODIGO_CLOSE CONDICION_OPEN condicion CONDICION_CLOSE DO_CLOSE ;
asignacion  : IDENT '=' expresion ';' ;
condicion   : expresion (COMPARADOR expresion)? (LOGICO condicion)? ;
expresion   : IDENT | NUM | expresion OP expresion ;

FUNCION         : '<funcion>' ;
FUNCION_CLOSE   : '</funcion>' ;
PARAMS_OPEN     : '<parametros>' ;
PARAMS_CLOSE    : '</parametros>' ;
CODIGO_OPEN     : '<codigo>' ;
CODIGO_CLOSE    : '</codigo>' ;
IF_OPEN         : '<if>' ;
IF_CLOSE        : '</if>' ;
DO_OPEN         : '<do>' ;
DO_CLOSE        : '</do>' ;
CONDICION_OPEN  : '<condicion>' ;
CONDICION_CLOSE : '</condicion>' ;

COMPARADOR : '>' | '<' | '>=' | '<=' | '==' | '!=' ;
LOGICO     : '&&' | '||' ;
OP         : '+' | '-' | '*' | '/' ;

IDENT : [a-zA-Z_][a-zA-Z0-9_]* ;
NUM   : [0-9]+ ;
WS    : [ \t\r\n]+ -> skip ;
