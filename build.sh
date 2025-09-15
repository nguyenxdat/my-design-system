#!/bin/bash

# Build script for My Design System Library
# Usage: ./build.sh [clean|build|test|publish-local|help]

set -e

PROJECT_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$PROJECT_ROOT"

function show_help() {
    echo "My Design System - Build Script"
    echo ""
    echo "Usage: ./build.sh [command]"
    echo ""
    echo "Commands:"
    echo "  clean          Clean all build artifacts"
    echo "  build          Build the library and demo app"
    echo "  test           Run unit tests"
    echo "  publish-local  Publish library to local Maven repository"
    echo "  demo           Build and install demo app"
    echo "  library        Build library only"
    echo "  help           Show this help message"
    echo ""
}

function clean_project() {
    echo "🧹 Cleaning project..."
    ./gradlew clean
    echo "✅ Clean completed"
}

function build_project() {
    echo "🔨 Building project..."
    ./gradlew build
    echo "✅ Build completed"
}

function run_tests() {
    echo "🧪 Running tests..."
    ./gradlew test
    echo "✅ Tests completed"
}

function publish_local() {
    echo "📦 Publishing to local Maven repository..."
    ./gradlew :library:publishToMavenLocal
    echo "✅ Published to local Maven repository"
    echo "You can now use it in other projects with:"
    echo "implementation 'com.github.nguyenxdat:my-design-system:1.0.0'"
}

function build_demo() {
    echo "📱 Building demo app..."
    ./gradlew :app:assembleDebug
    echo "✅ Demo app built successfully"
    echo "APK location: app/build/outputs/apk/debug/app-debug.apk"
}

function build_library() {
    echo "📚 Building library only..."
    ./gradlew :library:assembleRelease
    echo "✅ Library built successfully"
    echo "AAR location: library/build/outputs/aar/library-release.aar"
}

case "${1:-build}" in
    clean)
        clean_project
        ;;
    build)
        clean_project
        build_project
        ;;
    test)
        run_tests
        ;;
    publish-local)
        build_library
        publish_local
        ;;
    demo)
        build_demo
        ;;
    library)
        build_library
        ;;
    help|--help|-h)
        show_help
        ;;
    *)
        echo "❌ Unknown command: $1"
        echo ""
        show_help
        exit 1
        ;;
esac