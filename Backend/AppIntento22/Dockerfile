FROM ubuntu 
RUN apt-get update
RUN apt-get install wget -y 
RUN wget -q https://packages.microsoft.com/config/ubuntu/18.04/packages-microsoft-prod.deb -O packages-microsoft-prod.deb
RUN apt-get install software-properties-common -y
RUN dpkg -i packages-microsoft-prod.deb 
RUN add-apt-repository universe
RUN apt-get install apt-transport-https -y
RUN apt-get update -y
RUN apt-get install dotnet-sdk-2.2 -y
WORKDIR /app
COPY Controllers/ Controllers/
COPY Models/ Models/
COPY AppIntento22.csproj AppIntento22.csproj
COPY appsettings.Development.json appsettings.Development.json
COPY appsettings.json appsettings.json
COPY Program.cs Program.cs
COPY Startup.cs Startup.cs
RUN dotnet publish
ENTRYPOINT ["dotnet", "bin/Debug/netcoreapp2.2/publish/AppIntento22.dll"]
