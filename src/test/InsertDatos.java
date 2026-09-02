package test;

import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.HibernateUtil;
import datos.Cajero;
import datos.Cocinero;
import datos.Festival;
import datos.FoodTruck;
import datos.Pedido;
import datos.Plato;
import datos.PuestoDesarmable;

public class InsertDatos {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();

            // =====================================================
            // 1. FESTIVALES
            // =====================================================

            Festival festival1 = new Festival();
            festival1.setNombre("Festival Sabores del Sur");
            festival1.setTemporada("Primavera");
            festival1.setFechainicio(LocalDate.of(2026, 9, 10));
            festival1.setFechafin(LocalDate.of(2026, 9, 15));

            Festival festival2 = new Festival();
            festival2.setNombre("Feria Gastronomica Argentina");
            festival2.setTemporada("Verano");
            festival2.setFechainicio(LocalDate.of(2027, 1, 15));
            festival2.setFechafin(LocalDate.of(2027, 1, 20));

            Festival festival3 = new Festival();
            festival3.setNombre("Festival Internacional de Comida");
            festival3.setTemporada("Otono");
            festival3.setFechainicio(LocalDate.of(2027, 4, 5));
            festival3.setFechafin(LocalDate.of(2027, 4, 10));

            session.save(festival1);
            session.save(festival2);
            session.save(festival3);


            // =====================================================
            // 2. FOOD TRUCKS
            // =====================================================

            FoodTruck foodTruck1 = new FoodTruck();
            foodTruck1.setNombreComercial("Burger Truck");
            foodTruck1.setSuperficie(12.5f);
            foodTruck1.setCodigo(101);
            foodTruck1.setFestival(festival1);
            foodTruck1.setSueldoBase(300000f);
            foodTruck1.setCostoPorSuperficie(1500f);
            foodTruck1.setPatente("AB123CD");
            foodTruck1.setUsoElectricidad(25f);

            FoodTruck foodTruck2 = new FoodTruck();
            foodTruck2.setNombreComercial("Pizza Movil");
            foodTruck2.setSuperficie(10f);
            foodTruck2.setCodigo(102);
            foodTruck2.setFestival(festival2);
            foodTruck2.setSueldoBase(320000f);
            foodTruck2.setCostoPorSuperficie(1400f);
            foodTruck2.setPatente("AC456EF");
            foodTruck2.setUsoElectricidad(30f);

            FoodTruck foodTruck3 = new FoodTruck();
            foodTruck3.setNombreComercial("Tacos Express");
            foodTruck3.setSuperficie(11f);
            foodTruck3.setCodigo(103);
            foodTruck3.setFestival(festival3);
            foodTruck3.setSueldoBase(310000f);
            foodTruck3.setCostoPorSuperficie(1450f);
            foodTruck3.setPatente("AD789GH");
            foodTruck3.setUsoElectricidad(28f);

            session.save(foodTruck1);
            session.save(foodTruck2);
            session.save(foodTruck3);


            // =====================================================
            // 3. PUESTOS DESARMABLES
            // =====================================================

            PuestoDesarmable puesto1 = new PuestoDesarmable();
            puesto1.setNombreComercial("Empanadas Argentinas");
            puesto1.setSuperficie(8f);
            puesto1.setCodigo(201);
            puesto1.setFestival(festival1);
            puesto1.setSueldoBase(250000f);
            puesto1.setCostoPorSuperficie(1000f);
            puesto1.setCantidadCarpas(2);
            puesto1.setTiempoMontaje(60);
            puesto1.setCostoPorMontaje(50000f);

            PuestoDesarmable puesto2 = new PuestoDesarmable();
            puesto2.setNombreComercial("Parrilla Criolla");
            puesto2.setSuperficie(15f);
            puesto2.setCodigo(202);
            puesto2.setFestival(festival2);
            puesto2.setSueldoBase(280000f);
            puesto2.setCostoPorSuperficie(1200f);
            puesto2.setCantidadCarpas(3);
            puesto2.setTiempoMontaje(90);
            puesto2.setCostoPorMontaje(70000f);

            PuestoDesarmable puesto3 = new PuestoDesarmable();
            puesto3.setNombreComercial("Postres Caseros");
            puesto3.setSuperficie(6f);
            puesto3.setCodigo(203);
            puesto3.setFestival(festival3);
            puesto3.setSueldoBase(220000f);
            puesto3.setCostoPorSuperficie(900f);
            puesto3.setCantidadCarpas(1);
            puesto3.setTiempoMontaje(45);
            puesto3.setCostoPorMontaje(35000f);

            session.save(puesto1);
            session.save(puesto2);
            session.save(puesto3);


            // =====================================================
            // 4. CAJEROS
            // =====================================================

            Cajero cajero1 = new Cajero();
            cajero1.setNombre("Juan");
            cajero1.setApellido("Perez");
            cajero1.setDni(30111222);
            cajero1.setFechaNacimiento(LocalDate.of(1990, 5, 12));
            cajero1.setFechaIngreso(LocalDate.of(2024, 3, 10));
            cajero1.setSueldoBase(300000f);
            cajero1.setUnidadDeVenta(foodTruck1);
            cajero1.setHoraEntrada(LocalTime.of(9, 0));
            cajero1.setHoraSalida(LocalTime.of(17, 0));
            cajero1.setTurno("Manana");

            Cajero cajero2 = new Cajero();
            cajero2.setNombre("Maria");
            cajero2.setApellido("Gomez");
            cajero2.setDni(31222333);
            cajero2.setFechaNacimiento(LocalDate.of(1992, 8, 20));
            cajero2.setFechaIngreso(LocalDate.of(2023, 6, 15));
            cajero2.setSueldoBase(310000f);
            cajero2.setUnidadDeVenta(foodTruck2);
            cajero2.setHoraEntrada(LocalTime.of(14, 0));
            cajero2.setHoraSalida(LocalTime.of(22, 0));
            cajero2.setTurno("Tarde");

            Cajero cajero3 = new Cajero();
            cajero3.setNombre("Lucas");
            cajero3.setApellido("Fernandez");
            cajero3.setDni(32333444);
            cajero3.setFechaNacimiento(LocalDate.of(1988, 2, 8));
            cajero3.setFechaIngreso(LocalDate.of(2022, 9, 1));
            cajero3.setSueldoBase(320000f);
            cajero3.setUnidadDeVenta(puesto1);
            cajero3.setHoraEntrada(LocalTime.of(8, 0));
            cajero3.setHoraSalida(LocalTime.of(16, 0));
            cajero3.setTurno("Manana");

            session.save(cajero1);
            session.save(cajero2);
            session.save(cajero3);


            // =====================================================
            // 5. COCINEROS
            // =====================================================

            Cocinero cocinero1 = new Cocinero();
            cocinero1.setNombre("Pedro");
            cocinero1.setApellido("Sanchez");
            cocinero1.setDni(33444555);
            cocinero1.setFechaNacimiento(LocalDate.of(1985, 4, 10));
            cocinero1.setFechaIngreso(LocalDate.of(2021, 2, 15));
            cocinero1.setSueldoBase(400000f);
            cocinero1.setUnidadDeVenta(foodTruck1);
            cocinero1.setEspecialidad("Hamburguesas");
            cocinero1.setPlusPorCategoria(50000f);

            Cocinero cocinero2 = new Cocinero();
            cocinero2.setNombre("Sofia");
            cocinero2.setApellido("Rodriguez");
            cocinero2.setDni(34555666);
            cocinero2.setFechaNacimiento(LocalDate.of(1995, 11, 3));
            cocinero2.setFechaIngreso(LocalDate.of(2023, 4, 20));
            cocinero2.setSueldoBase(390000f);
            cocinero2.setUnidadDeVenta(foodTruck2);
            cocinero2.setEspecialidad("Pizza");
            cocinero2.setPlusPorCategoria(45000f);

            Cocinero cocinero3 = new Cocinero();
            cocinero3.setNombre("Martin");
            cocinero3.setApellido("Lopez");
            cocinero3.setDni(35666777);
            cocinero3.setFechaNacimiento(LocalDate.of(1987, 7, 25));
            cocinero3.setFechaIngreso(LocalDate.of(2020, 8, 15));
            cocinero3.setSueldoBase(420000f);
            cocinero3.setUnidadDeVenta(puesto2);
            cocinero3.setEspecialidad("Parrilla");
            cocinero3.setPlusPorCategoria(60000f);

            session.save(cocinero1);
            session.save(cocinero2);
            session.save(cocinero3);


            // =====================================================
            // 6. PEDIDOS
            // =====================================================

            Pedido pedido1 = new Pedido();
            pedido1.setFechaTransaccion(LocalDate.of(2026, 9, 10));
            pedido1.setUnidadDeVenta(foodTruck1);

            Pedido pedido2 = new Pedido();
            pedido2.setFechaTransaccion(LocalDate.of(2026, 9, 11));
            pedido2.setUnidadDeVenta(foodTruck2);

            Pedido pedido3 = new Pedido();
            pedido3.setFechaTransaccion(LocalDate.of(2027, 1, 16));
            pedido3.setUnidadDeVenta(puesto1);

            session.save(pedido1);
            session.save(pedido2);
            session.save(pedido3);


            // =====================================================
            // 7. PLATOS
            // =====================================================

            Plato plato1 = new Plato();
            plato1.setNombre("Hamburguesa Completa");
            plato1.setPrecioVenta(8500f);
            plato1.setCostoProduccion(3500f);
            plato1.setPedido(pedido1);
            plato1.setUnidadDeVenta(foodTruck1);

            Plato plato2 = new Plato();
            plato2.setNombre("Pizza Napolitana");
            plato2.setPrecioVenta(9000f);
            plato2.setCostoProduccion(4000f);
            plato2.setPedido(pedido2);
            plato2.setUnidadDeVenta(foodTruck2);

            Plato plato3 = new Plato();
            plato3.setNombre("Empanada de Carne");
            plato3.setPrecioVenta(2500f);
            plato3.setCostoProduccion(1000f);
            plato3.setPedido(pedido3);
            plato3.setUnidadDeVenta(puesto1);

            session.save(plato1);
            session.save(plato2);
            session.save(plato3);


            // =====================================================
            // COMMIT
            // =====================================================

            tx.commit();

            System.out.println("========================================");
            System.out.println("DATOS INSERTADOS CORRECTAMENTE");
            System.out.println("========================================");

        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }

            System.out.println("Error al insertar los datos:");
            e.printStackTrace();

        } finally {

            if (session != null && session.isOpen()) {
                session.close();
            }

        }

    }

}

