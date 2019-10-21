FROM mcr.microsoft.com/dotnet/core/aspnet:2.2-stretch-slim AS base
WORKDIR /app
EXPOSE 80
EXPOSE 443

FROM microsoft/dotnet:2.2-aspnetcore-runtime AS build
WORKDIR /src
COPY ["AppWeb/AppWeb.csproj", "AppWeb/"]
RUN dotnet restore "AppWeb/AppWeb.csproj"
COPY . .
WORKDIR "/src/AppWeb"
RUN dotnet build "AppWeb.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "AppWeb.csproj" -c Release -o /app/publish

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "AppWeb.dll"]