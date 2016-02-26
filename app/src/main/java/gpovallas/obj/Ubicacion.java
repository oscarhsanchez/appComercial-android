package gpovallas.obj;

import gpovallas.app.constants.GPOVallasConstants;

public class Ubicacion extends eEntity {

	public Ubicacion () {
		tableName = GPOVallasConstants.DB_TABLE_UBICACION;
	}
	
	public String pk_ubicacion;
    public String fk_pais;
    public String fk_empresa;
    public String unidad_negocio;
    public String tipo_medio;
    public String fk_plaza;
    public String estatus;
    public String ubicacion;
    public String direccion_comercial;
    public String referencia;
    public String categoria;
    public Integer catorcena;
    public Integer anio;
    public String fecha_instalacion;
    public String observaciones;
    public Double latitud;
    public Double longitud;
    public Integer reserva;
    public Integer estado;
    public String token;
	
}
