FROM ubuntu
WORKDIR /appC
RUN apt-get update
RUN apt-get install wget -y
RUN apt-get install -y gpg
RUN wget -qO- https://packages.microsoft.com/keys/microsoft.asc | gpg --dearmor > microsoft.as$RUN mv microsoft.asc.gpg /etc/apt/trusted.gpg.d/
RUN wget -q https://packages.microsoft.com/config/ubuntu/16.04/prod.list
RUN mv prod.list /etc/apt/sources.list.d/microsoft-prod.list
RUN chown root:root /etc/apt/trusted.gpg.d/microsoft.asc.gpg
RUN chown root:root /etc/apt/sources.list.d/microsoft-prod.list
RUN apt-get install -y apt-transport-https
RUN apt-get update
RUN apt-get install dotnet-sdk-2.2 -y

COPY Controllers/ Controllers/
COPY Models/ Models/
COPY Properties/ Properties/
COPY AppIntento22.csproj AppIntento22.csproj
COPY appsettings.Development.json appsettings.Development.json
COPY appsettings.json appsettings.json
COPY Program.cs Program.cs
COPY Startup.cs Startup.cs
RUN dotnet publish
ENTRYPOINT ["dotnet","bin/Debug/netcoreapp2.2/publish/AppIntento22.dll"]
