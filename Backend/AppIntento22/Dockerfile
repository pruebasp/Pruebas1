FROM mcr.microsoft.com/dotnet/core/sdk:2.2
WORKDIR /app

COPY . .
RUN dotnet publish
ENTRYPOINT ["dotnet","bin/Debug/netcoreapp2.2/publish/AppIntento22.dll"]