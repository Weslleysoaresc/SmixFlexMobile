package br.com.smixsistemas.smixflexmobile.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDHelper extends SQLiteOpenHelper {
    private static final String NOME_BD = "smixflexmobile";
    private static final int VERSAO_BD = 2;
    String resultado = null;

    public BDHelper(Context context){
        super(context, NOME_BD, null, VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
      bd.execSQL("CREATE TABLE CONFIGURACAO (ipServidor text, tipoComunicacao integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
      bd.execSQL("DROP TABLE CONFIGURACAO");
      onCreate(bd);
    }

    public void inserir(String ip, Integer tipo){
        SQLiteDatabase bd = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("ipServidor", ip);
        valores.put("tipoComunicacao", tipo);
        bd.insert("CONFIGURACAO",null, valores);
        bd.close();
    }

    public void atualizar (String ip){
        SQLiteDatabase bd = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("ipServidor", ip);
        bd.update("CONFIGURACAO",valores,null,null);
    }

    public void deletar (){
        SQLiteDatabase bd = this.getWritableDatabase();
        bd.delete("CONFIGURACAO",null,null);
    }

    public String[] buscar() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM CONFIGURACAO", null);

        String[] resultado = new String[2]; // Array para armazenar os valores das duas colunas

        if (cursor.moveToFirst()) {
            resultado[0] = cursor.getString(cursor.getColumnIndex("ipServidor"));
            resultado[1] = cursor.getString(cursor.getColumnIndex("tipoComunicacao"));
        }

        cursor.close(); // Certifique-se de fechar o cursor após o uso

        return resultado;
    }
}
