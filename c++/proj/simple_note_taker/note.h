#include <string>

class Note {
private:
    std::string title;
    std::string content;

public:
    Note(std::string title, std::string content) {
        this->content = content;
        this->title = title;
    }

    std::string getNoteContent() const {
        return this->content;
    }

    std::string getNoteTitle() const {
        return this->title;
    }

    void setNoteTitle(std::string title) {
        this->title = title;
        return;
    }

    void setNoteContent(std::string content) {
        this->content = content;
        return;
    }
};