using System;
using Microsoft.EntityFrameworkCore;

using Microsoft.EntityFrameworkCore.Metadata;

namespace prueba20
{
    public partial class bdanimalesContext : DbContext
    {
        public bdanimalesContext()
        {
        }

        public bdanimalesContext(DbContextOptions<bdanimalesContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Animal> Animal { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {

                //optionsBuilder.UseMySql("server=localhost;uid=root;pwd=uriel001;database=bdanimales");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Animal>(entity =>
            {
                entity.HasKey(e => e.Idanimal)
                    .HasName("PRIMARY");

                entity.ToTable("animal");

                entity.Property(e => e.Idanimal)
                    .HasColumnName("idanimal")
                    .HasColumnType("varchar(45)");

                entity.Property(e => e.NombreAnimal)
                    .HasColumnName("nombreAnimal")
                    .HasColumnType("varchar(45)");

                entity.Property(e => e.SegunEsqueleto)
                    .HasColumnName("segunEsqueleto")
                    .HasColumnType("varchar(45)");

                entity.Property(e => e.TipoAlimentacion)
                    .HasColumnName("tipoAlimentacion")
                    .HasColumnType("varchar(45)");

                entity.Property(e => e.TipoHabitad)
                    .HasColumnName("tipoHabitad")
                    .HasColumnType("varchar(45)");

                entity.Property(e => e.TipoReproduccion)
                    .HasColumnName("tipoReproduccion")
                    .HasColumnType("varchar(45)");
            });
        }
    }
}
