INSERT INTO public.rol(
            id, descripcion, estado)
    VALUES ('ADMINISTRADOR', 'Administrador del Sistema', 'ACT');
INSERT INTO public.rol(
            id, descripcion, estado)
    VALUES ('MEDICO', 'Medico', 'ACT');
INSERT INTO public.usuario(
            identificacion, apellido, direccion, email, estado, nombre, password)
    VALUES ('1718891052', 'LOPEZ', '12 de octubre', 'calopezf@gmail.com', 'ACT', 'CRISTIAN', '2f2e70c7b5ee74ca8f2250a11de7b277');
INSERT INTO public.usuario_rol(
            rol_id, usuario_identificacion)
    VALUES ('ADMINISTRADOR','1718891052');

