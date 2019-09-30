FROM mcr.microsoft.com/dotnet/core/aspnet:2.2-stretch-slim AS base
WORKDIR /app

COPY . .
RUN dotnet publish
ENTRYPOINT ["dotnet","bin/Debug/netcoreapp2.2/publish/AppIntento22.dll"]
