CREATE OR REPLACE PROCEDURE SP_RESET_PASS
(
P_ID_USER IN VARCHAR2, --Usuario
P_DBL IN VARCHAR2 --DBL
)
AS
--Variables de parámetros
V_ID_USER VARCHAR2(50);
V_DBL VARCHAR(50);

--Variables para sistemas
sql_stmt   varchar2(1000);

--Vairables para reseteo
V_EXIST NUMBER;
cursor_handle INTEGER;
cursor_handle_tmp INTEGER;

BEGIN
V_ID_USER:=P_ID_USER;
V_DBL:=P_DBL;
                                  
/*=====================================================================
SEGÚN EL DBL DE ENTRADA, SE VALIDA QUE EXISTA EL USUARIO Y NO ESTÉ 
BLOQUEADO, Y SE PROCEDE A PONER LA CONTRASEÑA IGUAL QUE EL USERNAME
=====================================================================*/

IF V_DBL ='@DBL_0101_UNICA' THEN
  
  --VALIDAR KE USUARIO DE BD EXISTA Y ESTÉ ACTIVO
  V_EXIST:=0;
  sql_stmt:='';
    sql_stmt:='SELECT COUNT(*) FROM SYS.DBA_USERS'||V_DBL||'  WHERE USERNAME ='''||V_ID_USER||''' AND ACCOUNT_STATUS = ''OPEN'''  ;
  dbms_output.put_line('sql_stmt: '|| sql_stmt);
  EXECUTE IMMEDIATE sql_stmt INTO V_EXIST;
  
  IF V_EXIST>0 THEN
      
     -- Open a Cursor on the REMOTE database
     cursor_handle := DBMS_SQL.OPEN_CURSOR@DBL_0101_UNICA;
     -- Parse the "change password"
     DBMS_SQL.PARSE@DBL_0101_UNICA(cursor_handle,'ALTER USER '||V_ID_USER||' IDENTIFIED BY '||V_ID_USER,DBMS_SQL.NATIVE);
     -- Execute the cursor
     cursor_handle_tmp := DBMS_SQL.EXECUTE@DBL_0101_UNICA(cursor_handle);
     -- Close the cursor
     DBMS_SQL.CLOSE_CURSOR@DBL_0101_UNICA(cursor_handle);

     dbms_output.put_line(''||V_ID_USER||' Reseteado en ' || V_DBL);
  ELSE
    raise_application_error(-20001,'USUARIO '||V_ID_USER||' NO EXISTE O NO ESTÁ ACTIVO EN BD: '||V_DBL||' ');
  END IF;
  
ELSIF V_DBL ='@DBL_0102_UNICA' THEN
  
  --VALIDAR KE USUARIO DE BD EXISTA Y ESTÉ ACTIVO
  V_EXIST:=0;
  sql_stmt:='';
  sql_stmt:='SELECT COUNT(*) FROM SYS.DBA_USERS'||V_DBL||'  WHERE USERNAME ='''||V_ID_USER||''' AND ACCOUNT_STATUS = ''OPEN'''  ;
  dbms_output.put_line('sql_stmt: '|| sql_stmt);
  EXECUTE IMMEDIATE sql_stmt INTO V_EXIST;
         
  IF V_EXIST>0 THEN
                      
     -- Open a Cursor on the REMOTE database
     cursor_handle := DBMS_SQL.OPEN_CURSOR@DBL_0102_UNICA;
     -- Parse the "change password"
     DBMS_SQL.PARSE@DBL_0102_UNICA(cursor_handle,'ALTER USER '||V_ID_USER||' IDENTIFIED BY '||V_ID_USER,DBMS_SQL.NATIVE);
     -- Execute the cursor
     cursor_handle_tmp := DBMS_SQL.EXECUTE@DBL_0102_UNICA(cursor_handle);
     -- Close the cursor
     DBMS_SQL.CLOSE_CURSOR@DBL_0102_UNICA(cursor_handle);

     dbms_output.put_line(''||V_ID_USER||' Reseteado en ' || V_DBL);
          
  ELSE
     raise_application_error(-20001,'USUARIO '||V_ID_USER||' NO EXISTE O NO ESTÁ ACTIVO EN BD : '||V_DBL||' ');
  END IF;
  
ELSIF V_DBL ='@DBL_0103_UNICA' THEN
  
  --VALIDAR KE USUARIO DE BD EXISTA Y ESTÉ ACTIVO
  V_EXIST:=0;
  sql_stmt:='';
  sql_stmt:='SELECT COUNT(*) FROM SYS.DBA_USERS'||V_DBL||'  WHERE USERNAME ='''||V_ID_USER||''' AND ACCOUNT_STATUS = ''OPEN'''  ;
  dbms_output.put_line('sql_stmt: '|| sql_stmt);
  EXECUTE IMMEDIATE sql_stmt INTO V_EXIST;
         
  IF V_EXIST>0 THEN
     -- Open a Cursor on the REMOTE database
     cursor_handle := DBMS_SQL.OPEN_CURSOR@DBL_0103_UNICA;
     -- Parse the "change password"
     DBMS_SQL.PARSE@DBL_0103_UNICA(cursor_handle,'ALTER USER '||V_ID_USER||' IDENTIFIED BY '||V_ID_USER,DBMS_SQL.NATIVE);
     -- Execute the cursor
     cursor_handle_tmp := DBMS_SQL.EXECUTE@DBL_0103_UNICA(cursor_handle);
     -- Close the cursor
     DBMS_SQL.CLOSE_CURSOR@DBL_0103_UNICA(cursor_handle);

     dbms_output.put_line(''||V_ID_USER||' Reseteado en ' || V_DBL);
     --V_BLOQ_OR0104 := TRUE;
  ELSE
     raise_application_error(-20001,'USUARIO '||V_ID_USER||' NO EXISTE O NO ESTÁ ACTIVO EN BD : '||V_DBL||' ');
  END IF;
       
ELSIF V_DBL ='@DBL_0104_UNICA' THEN
  
  --VALIDAR KE USUARIO DE BD EXISTA Y ESTÉ ACTIVO
  V_EXIST:=0;
  sql_stmt:='';
  sql_stmt:='SELECT COUNT(*) FROM SYS.DBA_USERS'||V_DBL||'  WHERE USERNAME ='''||V_ID_USER||''' AND ACCOUNT_STATUS = ''OPEN'''  ;
  dbms_output.put_line('sql_stmt: '|| sql_stmt);
  EXECUTE IMMEDIATE sql_stmt INTO V_EXIST;
         
  IF V_EXIST>0 THEN
                        
    -- Open a Cursor on the REMOTE database
    cursor_handle := DBMS_SQL.OPEN_CURSOR@DBL_0104_UNICA;
    -- Parse the "change password"
    DBMS_SQL.PARSE@DBL_0104_UNICA(cursor_handle,'ALTER USER '||V_ID_USER||' IDENTIFIED BY '||V_ID_USER,DBMS_SQL.NATIVE);
    -- Execute the cursor
    cursor_handle_tmp := DBMS_SQL.EXECUTE@DBL_0104_UNICA(cursor_handle);
    -- Close the cursor
    DBMS_SQL.CLOSE_CURSOR@DBL_0104_UNICA(cursor_handle);

    dbms_output.put_line(''||V_ID_USER||' Reseteado en ' || V_DBL);
    --V_BLOQ_OR0104 := TRUE;
                  
  ELSE
    raise_application_error(-20001,'USUARIO '||V_ID_USER||' NO EXISTE O NO ESTÁ ACTIVO EN BD : '||V_DBL||' ');
  END IF;
  
ELSIF V_DBL ='@DBL_0105_UNICA' THEN
  
  --VALIDAR KE USUARIO DE BD EXISTA Y ESTÉ ACTIVO
  V_EXIST:=0;
  sql_stmt:='';
  sql_stmt:='SELECT COUNT(*) FROM SYS.DBA_USERS'||V_DBL||'  WHERE USERNAME ='''||V_ID_USER||''' AND ACCOUNT_STATUS = ''OPEN'''  ;
  dbms_output.put_line('sql_stmt: '|| sql_stmt);
  EXECUTE IMMEDIATE sql_stmt INTO V_EXIST;
         
  IF V_EXIST>0 THEN      
          
    -- Open a Cursor on the REMOTE database
    cursor_handle := DBMS_SQL.OPEN_CURSOR@DBL_0105_UNICA;
    -- Parse the "change password"
    DBMS_SQL.PARSE@DBL_0105_UNICA(cursor_handle,'ALTER USER '||V_ID_USER||' IDENTIFIED BY '||V_ID_USER,DBMS_SQL.NATIVE);
    -- Execute the cursor
    cursor_handle_tmp := DBMS_SQL.EXECUTE@DBL_0105_UNICA(cursor_handle);
    -- Close the cursor
    DBMS_SQL.CLOSE_CURSOR@DBL_0105_UNICA(cursor_handle);

    dbms_output.put_line(''||V_ID_USER||' Reseteado en ' || V_DBL);
                          
  ELSE
    raise_application_error(-20001,'USUARIO '||V_ID_USER||' NO EXISTE O NO ESTÁ ACTIVO EN BD : '||V_DBL||' ');
  END IF;
  
ELSIF V_DBL ='@DBL_0106_UNICA' THEN
  
  --VALIDAR KE USUARIO DE BD EXISTA Y ESTÉ ACTIVO
  V_EXIST:=0;
  sql_stmt:='';
  sql_stmt:='SELECT COUNT(*) FROM SYS.DBA_USERS'||V_DBL||'  WHERE USERNAME ='''||V_ID_USER||''' AND ACCOUNT_STATUS = ''OPEN'''  ;
  dbms_output.put_line('sql_stmt: '|| sql_stmt);
  EXECUTE IMMEDIATE sql_stmt INTO V_EXIST;
         
  IF V_EXIST>0 THEN 
           
  -- Open a Cursor on the REMOTE database
  cursor_handle := DBMS_SQL.OPEN_CURSOR@DBL_0106_UNICA;
  -- Parse the "change password"
  DBMS_SQL.PARSE@DBL_0106_UNICA(cursor_handle,'ALTER USER '||V_ID_USER||' IDENTIFIED BY '||V_ID_USER,DBMS_SQL.NATIVE);
  -- Execute the cursor
  cursor_handle_tmp := DBMS_SQL.EXECUTE@DBL_0106_UNICA(cursor_handle);
  -- Close the cursor
  DBMS_SQL.CLOSE_CURSOR@DBL_0106_UNICA(cursor_handle);

  dbms_output.put_line(''||V_ID_USER||' Reseteado en ' || V_DBL);
                                       
  ELSE
    raise_application_error(-20001,'USUARIO '||V_ID_USER||' NO EXISTE O NO ESTÁ ACTIVO EN BD : '||V_DBL||' ');
  END IF;
  
ELSIF V_DBL ='@DBL_RPU_CALLAO' THEN
  
  --VALIDAR KE USUARIO DE BD EXISTA Y ESTÉ ACTIVO
  V_EXIST:=0;
  sql_stmt:='';
  sql_stmt:='SELECT COUNT(*) FROM SYS.DBA_USERS'||V_DBL||'  WHERE USERNAME ='''||V_ID_USER||''' AND ACCOUNT_STATUS = ''OPEN'''  ;
  dbms_output.put_line('sql_stmt: '|| sql_stmt);
  EXECUTE IMMEDIATE sql_stmt INTO V_EXIST;
         
  IF V_EXIST>0 THEN
                      
     -- Open a Cursor on the REMOTE database
     cursor_handle := DBMS_SQL.OPEN_CURSOR@DBL_RPU_CALLAO;
     -- Parse the "change password"
     DBMS_SQL.PARSE@DBL_RPU_CALLAO(cursor_handle,'ALTER USER '||V_ID_USER||' IDENTIFIED BY '||V_ID_USER,DBMS_SQL.NATIVE);
     -- Execute the cursor
     cursor_handle_tmp := DBMS_SQL.EXECUTE@DBL_RPU_CALLAO(cursor_handle);
     -- Close the cursor
     DBMS_SQL.CLOSE_CURSOR@DBL_RPU_CALLAO(cursor_handle);

     dbms_output.put_line(''||V_ID_USER||' Reseteado en ' || V_DBL);
          
  ELSE
     raise_application_error(-20001,'USUARIO '||V_ID_USER||' NO EXISTE O NO ESTÁ ACTIVO EN BD : '||V_DBL||' ');
  END IF;
  
ELSIF V_DBL ='@DBL_HUARAL_RPU' THEN
  
  --VALIDAR KE USUARIO DE BD EXISTA Y ESTÉ ACTIVO
  V_EXIST:=0;
  sql_stmt:='';
  sql_stmt:='SELECT COUNT(*) FROM SYS.DBA_USERS'||V_DBL||'  WHERE USERNAME ='''||V_ID_USER||''' AND ACCOUNT_STATUS = ''OPEN'''  ;
  dbms_output.put_line('sql_stmt: '|| sql_stmt);
  EXECUTE IMMEDIATE sql_stmt INTO V_EXIST;
         
  IF V_EXIST>0 THEN
     -- Open a Cursor on the REMOTE database
     cursor_handle := DBMS_SQL.OPEN_CURSOR@DBL_HUARAL_RPU;
     -- Parse the "change password"
     DBMS_SQL.PARSE@DBL_HUARAL_RPU(cursor_handle,'ALTER USER '||V_ID_USER||' IDENTIFIED BY '||V_ID_USER,DBMS_SQL.NATIVE);
     -- Execute the cursor
     cursor_handle_tmp := DBMS_SQL.EXECUTE@DBL_HUARAL_RPU(cursor_handle);
     -- Close the cursor
     DBMS_SQL.CLOSE_CURSOR@DBL_HUARAL_RPU(cursor_handle);

     dbms_output.put_line(''||V_ID_USER||' Reseteado en ' || V_DBL);
     --V_BLOQ_OR0104 := TRUE;
  ELSE
     raise_application_error(-20001,'USUARIO '||V_ID_USER||' NO EXISTE O NO ESTÁ ACTIVO EN BD : '||V_DBL||' ');
  END IF;
  
ELSIF V_DBL ='@DBL_RPU_HUACHO' THEN
  
  --VALIDAR KE USUARIO DE BD EXISTA Y ESTÉ ACTIVO
  V_EXIST:=0;
  sql_stmt:='';
  sql_stmt:='SELECT COUNT(*) FROM SYS.DBA_USERS'||V_DBL||'  WHERE USERNAME ='''||V_ID_USER||''' AND ACCOUNT_STATUS = ''OPEN'''  ;
  dbms_output.put_line('sql_stmt: '|| sql_stmt);
  EXECUTE IMMEDIATE sql_stmt INTO V_EXIST;
         
  IF V_EXIST>0 THEN
                        
    -- Open a Cursor on the REMOTE database
    cursor_handle := DBMS_SQL.OPEN_CURSOR@DBL_RPU_HUACHO;
    -- Parse the "change password"
    DBMS_SQL.PARSE@DBL_RPU_HUACHO(cursor_handle,'ALTER USER '||V_ID_USER||' IDENTIFIED BY '||V_ID_USER,DBMS_SQL.NATIVE);
    -- Execute the cursor
    cursor_handle_tmp := DBMS_SQL.EXECUTE@DBL_RPU_HUACHO(cursor_handle);
    -- Close the cursor
    DBMS_SQL.CLOSE_CURSOR@DBL_RPU_HUACHO(cursor_handle);

    dbms_output.put_line(''||V_ID_USER||' Reseteado en ' || V_DBL);
    --V_BLOQ_OR0104 := TRUE;
                  
  ELSE
    raise_application_error(-20001,'USUARIO '||V_ID_USER||' NO EXISTE O NO ESTÁ ACTIVO EN BD : '||V_DBL||' ');
  END IF;
  
ELSIF V_DBL ='@DBL_RPU_CANETE' THEN
  
  --VALIDAR KE USUARIO DE BD EXISTA Y ESTÉ ACTIVO
  V_EXIST:=0;
  sql_stmt:='';
  sql_stmt:='SELECT COUNT(*) FROM SYS.DBA_USERS'||V_DBL||'  WHERE USERNAME ='''||V_ID_USER||''' AND ACCOUNT_STATUS = ''OPEN'''  ;
  dbms_output.put_line('sql_stmt: '|| sql_stmt);
  EXECUTE IMMEDIATE sql_stmt INTO V_EXIST;
         
  IF V_EXIST>0 THEN      
          
    -- Open a Cursor on the REMOTE database
    cursor_handle := DBMS_SQL.OPEN_CURSOR@DBL_RPU_CANETE;
    -- Parse the "change password"
    DBMS_SQL.PARSE@DBL_RPU_CANETE(cursor_handle,'ALTER USER '||V_ID_USER||' IDENTIFIED BY '||V_ID_USER,DBMS_SQL.NATIVE);
    -- Execute the cursor
    cursor_handle_tmp := DBMS_SQL.EXECUTE@DBL_RPU_CANETE(cursor_handle);
    -- Close the cursor
    DBMS_SQL.CLOSE_CURSOR@DBL_RPU_CANETE(cursor_handle);

    dbms_output.put_line(''||V_ID_USER||' Reseteado en ' || V_DBL);
                          
  ELSE
    raise_application_error(-20001,'USUARIO '||V_ID_USER||' NO EXISTE O NO ESTÁ ACTIVO EN BD : '||V_DBL||' ');
  END IF;
   
ELSIF V_DBL ='@DBL_BARRANCA_RPU' THEN
  
  --VALIDAR KE USUARIO DE BD EXISTA Y ESTÉ ACTIVO
  V_EXIST:=0;
  sql_stmt:='';
  sql_stmt:='SELECT COUNT(*) FROM SYS.DBA_USERS'||V_DBL||'  WHERE USERNAME ='''||V_ID_USER||''' AND ACCOUNT_STATUS = ''OPEN'''  ;
  dbms_output.put_line('sql_stmt: '|| sql_stmt);
  EXECUTE IMMEDIATE sql_stmt INTO V_EXIST;
         
  IF V_EXIST>0 THEN 
           
  -- Open a Cursor on the REMOTE database
  cursor_handle := DBMS_SQL.OPEN_CURSOR@DBL_BARRANCA_RPU;
  -- Parse the "change password"
  DBMS_SQL.PARSE@DBL_BARRANCA_RPU(cursor_handle,'ALTER USER '||V_ID_USER||' IDENTIFIED BY '||V_ID_USER,DBMS_SQL.NATIVE);
  -- Execute the cursor
  cursor_handle_tmp := DBMS_SQL.EXECUTE@DBL_BARRANCA_RPU(cursor_handle);
  -- Close the cursor
  DBMS_SQL.CLOSE_CURSOR@DBL_BARRANCA_RPU(cursor_handle);

  dbms_output.put_line(''||V_ID_USER||' Reseteado en ' || V_DBL);
                                       
  ELSE
    raise_application_error(-20001,'USUARIO '||V_ID_USER||' NO EXISTE O NO ESTÁ ACTIVO EN BD : '||V_DBL||' ');
  END IF;
  
ELSIF V_DBL ='@DBL_RPU_ESTE' THEN
  
  --VALIDAR KE USUARIO DE BD EXISTA Y ESTÉ ACTIVO
  V_EXIST:=0;
  sql_stmt:='';
  sql_stmt:='SELECT COUNT(*) FROM SYS.DBA_USERS'||V_DBL||'  WHERE USERNAME ='''||V_ID_USER||''' AND ACCOUNT_STATUS = ''OPEN'''  ;
  dbms_output.put_line('sql_stmt: '|| sql_stmt);
  EXECUTE IMMEDIATE sql_stmt INTO V_EXIST;
         
  IF V_EXIST>0 THEN 
                               
    -- Open a Cursor on the REMOTE database
    cursor_handle := DBMS_SQL.OPEN_CURSOR@DBL_RPU_ESTE;
    -- Parse the "change password"
    DBMS_SQL.PARSE@DBL_RPU_ESTE(cursor_handle,'ALTER USER '||V_ID_USER||' IDENTIFIED BY '||V_ID_USER,DBMS_SQL.NATIVE);
    -- Execute the cursor
    cursor_handle_tmp := DBMS_SQL.EXECUTE@DBL_RPU_ESTE(cursor_handle);
    -- Close the cursor
    DBMS_SQL.CLOSE_CURSOR@DBL_RPU_ESTE(cursor_handle);

    dbms_output.put_line(''||V_ID_USER||' Reseteado en ' || V_DBL);
                                         
  ELSE
    raise_application_error(-20001,'USUARIO '||V_ID_USER||' NO EXISTE O NO ESTÁ ACTIVO EN BD : '||V_DBL||' ');
  END IF;
         
ELSIF V_DBL ='@DBL_RPU_NORTE' THEN
  
  --VALIDAR KE USUARIO DE BD EXISTA Y ESTÉ ACTIVO
  V_EXIST:=0;
  sql_stmt:='';
  sql_stmt:='SELECT COUNT(*) FROM SYS.DBA_USERS'||V_DBL||'  WHERE USERNAME ='''||V_ID_USER||''' AND ACCOUNT_STATUS = ''OPEN'''  ;
  dbms_output.put_line('sql_stmt: '|| sql_stmt);
  EXECUTE IMMEDIATE sql_stmt INTO V_EXIST;
           
  IF V_EXIST>0 THEN 
                      
    -- Open a Cursor on the REMOTE database
    cursor_handle := DBMS_SQL.OPEN_CURSOR@DBL_RPU_NORTE;
    -- Parse the "change password"
    DBMS_SQL.PARSE@DBL_RPU_NORTE(cursor_handle,'ALTER USER '||V_ID_USER||' IDENTIFIED BY '||V_ID_USER,DBMS_SQL.NATIVE);
    -- Execute the cursor
    cursor_handle_tmp := DBMS_SQL.EXECUTE@DBL_RPU_NORTE(cursor_handle);
    -- Close the cursor
    DBMS_SQL.CLOSE_CURSOR@DBL_RPU_NORTE(cursor_handle);
    dbms_output.put_line(''||V_ID_USER||' Reseteado en ' || V_DBL);
                                         
  ELSE
    raise_application_error(-20001,'USUARIO '||V_ID_USER||' NO EXISTE O NO ESTÁ ACTIVO EN BD : '||V_DBL||' ');
  END IF;
  
ELSIF V_DBL ='@DBL_RPU_SUR' THEN
  --VALIDAR KE USUARIO DE BD EXISTA Y ESTÉ ACTIVO
  V_EXIST:=0;
  sql_stmt:='';
  sql_stmt:='SELECT COUNT(*) FROM SYS.DBA_USERS'||V_DBL||'  WHERE USERNAME ='''||V_ID_USER||''' AND ACCOUNT_STATUS = ''OPEN'''  ;
  dbms_output.put_line('sql_stmt: '|| sql_stmt);
  EXECUTE IMMEDIATE sql_stmt INTO V_EXIST;
           
  IF V_EXIST>0 THEN 
                              
    -- Open a Cursor on the REMOTE database
    cursor_handle := DBMS_SQL.OPEN_CURSOR@DBL_RPU_SUR;
    -- Parse the "change password"
    DBMS_SQL.PARSE@DBL_RPU_SUR(cursor_handle,'ALTER USER '||V_ID_USER||' IDENTIFIED BY '||V_ID_USER,DBMS_SQL.NATIVE);
    -- Execute the cursor
    cursor_handle_tmp := DBMS_SQL.EXECUTE@DBL_RPU_SUR(cursor_handle);
    -- Close the cursor
    DBMS_SQL.CLOSE_CURSOR@DBL_RPU_SUR(cursor_handle);
    dbms_output.put_line(''||V_ID_USER||' Reseteado en ' || V_DBL);
                                         
  ELSE
    raise_application_error(-20001,'USUARIO '||V_ID_USER||' NO EXISTE O NO ESTÁ ACTIVO EN BD : '||V_DBL||' ');
  END IF;
END IF;
                           
END;
