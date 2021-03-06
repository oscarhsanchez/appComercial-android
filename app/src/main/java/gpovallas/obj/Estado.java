package gpovallas.obj;

public class Estado {
	
	public enum status {
		BORRADO,
		ACTIVO,
		EDITABLE,
		OK,
		ERROR_SYNCRONIZACION,
		GENERAL_FAIL,
		NOT_CONNECTION,
		DATABASE_ERROR,
		ERROR_PARAM,
		CONSULTA_NO_ENCONTRADA,
		CLAVE_DUPLICADA,
		USER_IN_SESSION,
		USER_PASSWORD_INVALID,
		NOT_SESSION_FOUND,
		INSUFFICIENT_PERMISSION,
		USER_INVALID,
		USER_NOT_IN_MOVEX,
		CLIENT_INVALID,
		PERFIL_NOT_VALID,
		FECHA_RUTA_NOT_FOUND,
		VISITA_EN_RUTA_EXISTENTE,
		PRODUCCION,
		AVERIADO,
		REPARANDO,
		BAJA,
		SOLICITADO,
		EN_PROCESO,
		FINALIZADO,
		NO_INICIALIZADO,
		APROBADO,
		RECHAZADO
	}
	
}