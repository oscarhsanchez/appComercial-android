package gpovallas.app.medios;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Arrays;

import gpovallas.adapter.MeanGaleriaAdapter;
import gpovallas.app.ApplicationStatus;
import gpovallas.app.R;
import gpovallas.app.constants.GPOVallasConstants;
import gpovallas.db.controllers.UbicacionCtrl;
import gpovallas.obj.TO.ImagenUbicacion;
import gpovallas.obj.Ubicacion;
import gpovallas.ws.request.GetImagenesUbicacionRequest;
import gpovallas.ws.response.GetImagenesUbicacionResponse;

public class MeanTabListadosDetailTabGaleriaFragment extends Fragment implements AdapterView.OnItemClickListener {

    private static final String TAG = MeanTabListadosDetailTabGaleriaFragment.class.getSimpleName();

    private GridView mGridView;
    private MeanGaleriaAdapter mMeanGaleriaAdapter;
    private TextView mEmptyView;
    private String pk_ubicacion;
    private Ubicacion mUbicacion;
    private SQLiteDatabase db;

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.mean_tab_listados_detail_tab_galeria, container, false);

        mGridView = (GridView) view.findViewById(R.id.gridView);
        mEmptyView = (TextView) view.findViewById(android.R.id.empty);
        mGridView.setEmptyView(mEmptyView);
        mGridView.setOnItemClickListener(this);

        db = ApplicationStatus.getInstance().getDbRead(getActivity());

        Bundle bundle = getArguments();
        Log.i(TAG, bundle.toString());
        if (bundle != null) {
            pk_ubicacion = bundle.getString(GPOVallasConstants.LISTADO_PK_INTENT);
            mUbicacion = new UbicacionCtrl(db).getUbicacionById(pk_ubicacion);
            Log.i(TAG, pk_ubicacion);
            // Llamar asynctask
            new ImagenesTask().execute(pk_ubicacion);
        }

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ImagenUbicacion imagen = (ImagenUbicacion) parent.getItemAtPosition(position);
        // Abrimos la nueva actividad
        Log.i(TAG, imagen.url + imagen.nombre);

        Intent intent = new Intent(getActivity(), MeanGaleriaZoomActivity.class);
        intent.putExtra(GPOVallasConstants.BREADCUMB_TITLE,"Medios");
        intent.putExtra(GPOVallasConstants.PATH_IMAGE,imagen.url + imagen.nombre);
        intent.putExtra(GPOVallasConstants.IMAGE_TITLE,mUbicacion.ubicacion);
        startActivity(intent);
    }

    // Definir asynctask para obtener las imagenes desde internet
    private class ImagenesTask extends AsyncTask<String, Integer, GetImagenesUbicacionResponse> {

        @Override
        protected GetImagenesUbicacionResponse doInBackground(String... params) {
            GetImagenesUbicacionRequest request = new GetImagenesUbicacionRequest();
            return request.execute(params[0], GetImagenesUbicacionResponse.class);
        }

        @Override
        protected void onPostExecute(GetImagenesUbicacionResponse response) {
            //if(progressDialog!=null) progressDialog.dismiss();
            if (response != null && !response.failed()) {
                mMeanGaleriaAdapter = new MeanGaleriaAdapter(getActivity(),
                        R.layout.mean_galeria_item,
                        Arrays.asList(response.imagenes));
                mGridView.setAdapter(mMeanGaleriaAdapter);
            } else {
                Log.d(TAG, "No se pudieron cargar las imagenes correctamente");
            }
        }

    }

}
