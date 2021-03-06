package gpovallas.obj;

import gpovallas.app.constants.GPOVallasConstants;

/**
 * Created by synergy on 16/03/16.
 */
public class TipoMedio extends eEntity {

    public TipoMedio(){ tableName = GPOVallasConstants.DB_TABLE_TIPOS_MEDIOS; }

    public String pk_tipo;
    public String fk_pais;
    public String fk_empresa;
    public String unidad_negocio;
    public String descripcion;
    public Integer estado;
    public String token;
    public String nombre;
}
