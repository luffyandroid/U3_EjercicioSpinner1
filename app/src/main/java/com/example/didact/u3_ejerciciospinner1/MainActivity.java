package com.example.didact.u3_ejerciciospinner1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    Spinner spTipo;
    RadioGroup rgRespuesta;
    CheckBox cbRepetida;
    Button btnRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spTipo = (Spinner)findViewById(R.id.sp_tipo);
        rgRespuesta = (RadioGroup)findViewById(R.id.rg_respuesta);
        cbRepetida = (CheckBox)findViewById(R.id.cb_repetida);
        btnRespuesta = (Button)findViewById(R.id.btn_respuesta);

        String[] tipos={"Selecciona","Seguridad","Velocidad","Mecánica","Vial"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,tipos);
        spTipo.setAdapter(adaptador);


    }

    public void clickTipoTest(View view){
        //Recoger el item seleccionado en el spinner
        String tipoSeleccionado = spTipo.getSelectedItem().toString();

        /*validacion: si el tipoSeleccionado es igual a "Selecciona" avisaremos
                    al usuario de que tiene que seleccionar algun tipo, sino
                    lo mostraremos en un toast*/

        if(tipoSeleccionado.equals("Selecciona")){
            Toast.makeText(this, "Debes seleccionar un tipo de test", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Test seleccionado: "+tipoSeleccionado,
                    Toast.LENGTH_LONG).show();
            btnRespuesta.setEnabled(true);
        }
    }

    public void clickRespuesta(View view){
        //Obtenemos la id del Radiobutton seleccionado dentro del Radiogroup
        int idRadio = rgRespuesta.getCheckedRadioButtonId();

        if (idRadio == -1){
            Toast.makeText(this, "Debes seleccionar una respuesta",
                    Toast.LENGTH_SHORT).show();
        }else{
            //Creamos un objeto Radiobutton desde la id obtenida
            RadioButton radioButtonSeleccionado = (RadioButton)findViewById(idRadio);
            //Del objeto radiobutton creado obtenemos el texto del mismo
            String textoRadioSeleccionado = radioButtonSeleccionado.getText().toString();


            //Comprobar si el checkbox esta seleccionado
            boolean esRepetida=false;

            if(cbRepetida.isChecked()){
                esRepetida=true;
            }

            if(esRepetida){
                Toast.makeText(this, "Esta pregunta ya la has contestado",
                        Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Opción seleccionada "+textoRadioSeleccionado,
                        Toast.LENGTH_SHORT).show();
            }

        }

    }

}
