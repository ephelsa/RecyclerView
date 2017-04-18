package co.edu.udea.compumovil.gr09_20171.recyclerview;

import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Principal extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private List<Datos> datosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        iniciar();
    }

    private void iniciar() {

        //Los datosList.add se borran.
        int imagen = 0; // Hay que conservar esto. Dado que aquí pondrémos la dirección de cada img.
        datosList = new ArrayList<>();

        datosList.add(new Datos(R.mipmap.ic_launcher, "Leonardo", "19 años"));
        datosList.add(new Datos(R.mipmap.ic_lanzador, "Lanzador :v", "Oie no c"));
        datosList.add(new Datos(R.mipmap.ic_launcher_round, "Rounddd xd", "Baia baia"));

        for (int i = 0; i < 20; i++) {
            datosList.add(new Datos(R.mipmap.ic_launcher_round, "Nombre" + i, "Edad" + i));  // Datos de la base de datos.
        }

        initializeAdapter();
    }

    private void initializeAdapter() {
        Adaptador adaptador = new Adaptador(datosList);
        recyclerView.setAdapter(adaptador);

    }
}
