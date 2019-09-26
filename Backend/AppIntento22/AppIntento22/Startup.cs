using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.EntityFrameworkCore;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Options;
using prueba20;
using AppIntento22.Dao;
using AppIntento22.BusinessService;

namespace AppIntento22
{
    public class Startup
    {
        
        public Startup(IHostingEnvironment env)
        {
            // Aumentando ◙◙◙◙
            var builder = new ConfigurationBuilder()
              .SetBasePath(env.ContentRootPath)
              .AddJsonFile("appsettings.json", optional: false, reloadOnChange: true)
              .AddJsonFile($"appsettings.{env.EnvironmentName}.json", optional: true)
              .AddEnvironmentVariables();
            Configuration = builder.Build();
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            // "server=192.168.0.200;port=6003;uid=root;pwd=my-secret-pw;database=bdanimales"

            

            //services.AddDbContext<bdanimalesContext>(ConnectionString: Configuration.GetConnectionString("DefaultConnectionMongo"));
            //services.AddDbContext<bdanimalesContext>(options => options.UsePostgreSql(Configuration.GetConnectionString("DefaultConnectionPostgres")));

            services.AddMvc().SetCompatibilityVersion(CompatibilityVersion.Version_2_2);

           
            //services.AddSingleton<IAnimal, AnimalRepository>();
            services.AddScoped<AnimalBusinessService>();

            //
            //services.AddTransient<AnimalRepositorioMongo>();

            if (Configuration.GetValue<string>("DB") == "mysql")
            {
                services.AddDbContext<bdanimalesContext>(options => options.UseMySql(Configuration.GetConnectionString("DefaultConnectionMySql")));
                services.AddScoped<IAnimal, AnimalRepository>();
            }
            else
            {
                if (Configuration.GetValue<string>("DB") == "mongo")
                {
                    
                    services.AddScoped<IAnimal, AnimalRepositorioMongo>();
                }
            }
            //services.AddTransient<IAnimal>();
            //services.UsePostgresl
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IHostingEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
                app.UseHsts();
            }

            app.UseHttpsRedirection();
            app.UseMvc();
        }
    }
}
