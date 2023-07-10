#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <limits>
#include <stdlib.h>
#include <iomanip>
#include "note.h"

void clearConsole() {
    system("clear");
    return;
}

void displayActionsMain() {
    std::cout << "Please select the action you want to perform: (1-4)\n";
    std::cout << "1. See my notes\n";
    std::cout << "2. Add a new note\n";
    std::cout << "3. Modify an already existing note\n";
    std::cout << "4. End the program\n";
    return;
}

void displayActionsModify() {
    std::cout << "Please select the action you want to perform (1-3)\n";
    std::cout << "1. Modify title of existing note\n";
    std::cout << "2. Modify content of existing note\n";
    std::cout << "3. Delete existing note\n";
    std::cout << "4. Go Back\n";
    return;
}

int checkUserInput(std::string option, int num_of_options) {
    // check if the input is a number, else return invalid
    if (option.length() > 1) {
        return -1;
    }
    if (option < "0" or option > "9") {
        return -1;
    }

    int user_input = std::stoi(option);
    for (int i = 1; i <= num_of_options; i++) {
        if (user_input == i) {
            return i;
        }
    }
    // invalid input
    return -1;
}

void addNewNote(std::vector<Note>& notes, const std::string& title, const std::string& content) {
    Note newNote(title, content);
    notes.push_back(newNote);
}

void exportNotes(const std::vector<Note>& notes) {
    std::ofstream file("notes.txt");
    if (file.is_open()) {
        for (const auto& note : notes) {
            file << note.getNoteTitle() << "\n" << note.getNoteContent() << "!ENDNOTE!\n";
        }
        file.close();
    } else {
        std::cout << "Unable to open the file for writing." << std::endl;
    }
}

void importNotes(std::vector<Note> &notes) {
    std::ifstream file("notes.txt");
    if (file.is_open()) {
        std::string line = "", title = "", content = "";
        while (std::getline(file, line)) {
            if (line == "!ENDNOTE!") {
                if (!title.empty() and !content.empty()) {
                    addNewNote(notes, title, content);
                    title = "";
                    content = "";
                }
            } else if (title.empty()) {
                title = line;
            } else {
                content += line + "\n";
            }
        }
        file.close();
    } else {
        std::cout << "Unable to open the file for reading!\n";
    }
}

bool findNote(const std::vector<Note> notes, std::string title) {
    for (const auto note : notes) {
        if (note.getNoteTitle() == title) {
            return true;
        }
    }
    std::cout << "Note " << title << " does not exist! Press ENTER to continue.";
    std::cin.get();
    return false;
}

void changeTitle(std::vector<Note> &notes, std::string old_title, std::string new_title) {
    for (auto &note : notes) {
        if (note.getNoteTitle() == old_title) {
            note.setNoteTitle(new_title);
            std::cout << "Title of note " << old_title << " changed to " << new_title << ". Press ENTER to continue.\n";
            std::cin.get();
            return;
        }
    }
    
    std::cout << "Note " << old_title << " does not exist! Press ENTER to continue.";
    std::cin.get();
    return;

}

void changeContent(std::vector<Note> &notes, std::string title, std::string new_content) {
    for (auto &note : notes) {
        if (note.getNoteTitle() == title) {
            note.setNoteContent(new_content);
            std::cout << "Succesfully modified content of note " << title << ". Press ENTER to continue.";
            std::cin.get();
            return;
        }
    }

    std::cout << "Note " << title << " does not exist! Press ENTER to continue.\n";
    std::cin.get();
    return;
}

void deleteNote(std::vector<Note> &notes, std::string title) {
    for (auto it = notes.begin(); it != notes.end(); ) {
        if (it->getNoteTitle() == title) {
            notes.erase(it);
            std::cout << "Note " << title << " succesfull deleted. Press ENTER to continue.";
            std::cin.get();
            return;
        }
        else {
            ++it;
        }
    }

    std::cout << "Note " << title << " does not exist! Press ENTER to continue.";
    std::cin.get();
    return;
}

void displayNotes(const std::vector<Note>& notes) {
    const int MAX_LEN = 75;

    for (const auto& note : notes) {
        std::cout << "+" << std::string(MAX_LEN, '-') << "+" << std::endl;
        std::cout << "| " << std::setw(MAX_LEN - 2) << std::left << note.getNoteTitle().substr(0, MAX_LEN - 3) << " |" << std::endl;

        // Split the note content by newlines
        std::istringstream iss(note.getNoteContent());
        std::string line;
        while (std::getline(iss, line)) {
            // Handle lines longer than MAX_LEN - 3 characters
            if (line.length() > MAX_LEN - 3) {
                int pos = 0;
                while (pos < line.length()) {
                    std::string truncatedLine = line.substr(pos, MAX_LEN - 3);
                    std::cout << "| " << std::setw(MAX_LEN - 2) << std::left << truncatedLine << " |" << std::endl;
                    pos += MAX_LEN - 3;
                }
            } else {
                std::cout << "| " << std::setw(MAX_LEN - 2) << std::left << line << " |" << std::endl;
            }
        }

        std::cout << "+" << std::string(MAX_LEN, '-') << "+" << std::endl;
        std::cout << std::endl; // Add an extra line between notes
    }

    std::cout << "\nPress ENTER to continue.";
    std::cin.get();
    return;
}

void displayTitles(const std::vector<Note>& notes) {
    std::cout << "These are your notes: ";
    auto it = notes.begin();
    if (it != notes.end()) {
        std::cout << it->getNoteTitle();
        ++it;
    }
    for (; it != notes.end(); ++it) {
        std::cout << ", " << it->getNoteTitle();
    }
    std::cout << std::endl;
}

int main() {
    std::vector<Note> notes;
    importNotes(notes);

    int num_of_main_user_choices = 4;
    bool end_program = false;

    clearConsole();
    while (!end_program) {
        displayActionsMain();

        // get user input
        std::string option;
        std::cout << "Enter your choice: ";
        std::cin >> option;

        // check the user's input
        int user_choice = checkUserInput(option, num_of_main_user_choices);
        if (user_choice == -1) {
            clearConsole();
            std::cout << "Invalid input. Please try again!\n";
            continue;
        }

        clearConsole();

        std::string note_title, note_content;
        // see the notes
        if (user_choice == 1) {
            displayNotes(notes);
            std::cin.get();
        }

        // add a new note
        if (user_choice == 2) {
            // get note title
            std::cout << "Title of the note: ";
            std::cin >> note_title;
        
            bool title_taken = false;
            for (const auto note : notes) {
                if (note.getNoteTitle() == note_title) {
                    title_taken = true;
                    break;
                }
            }

            if (title_taken) {
                std::cout << "A note with this title already exists! Press ENTER to continue.";
                std::cin.get();
                std::cin.get();
                clearConsole();
            } else {
                // get note content 
                std::cout << "Content of your note (enter '!ENDNOTE!' on a separate line to finish):\n";
                std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n'); // Ignore remaining newline character after reading the note_title
                note_content = "";
                std::string line;
                while (std::getline(std::cin, line)) {
                    if (line == "!ENDNOTE!")
                        break;
                    note_content += line + "\n";
                }
            
                // add the note
                addNewNote(notes, note_title, note_content);
                std::cout << "Note created succesfully! Press ENTER to continue.";
                std::cin.get();
                clearConsole();
            }
        }

        // modify existing note
        if (user_choice == 3) {
            int num_of_modify_user_choices = 4;

            // display menu to choose action
            displayActionsModify();

            // get which part of the note to modify (title, content, delete)
            std::string modify = "";
            std::cout << "Enter your choice: ";
            std::cin >> modify;
            
            // check the user's input, until is valid keep asking for input
            int value_modify = checkUserInput(modify, num_of_modify_user_choices);
            while (value_modify == -1) {
                clearConsole();
                std::cout << "Invalid input. Please try again!\n";
                displayActionsModify();
                std::cout << "Enter your choice: ";
                std::cin >> modify;
                value_modify = checkUserInput(modify, num_of_modify_user_choices);
            }

            clearConsole();
            // change title of the note
            if (value_modify == 1) {
                displayTitles(notes);

                // get the old title of the note
                std::string new_title = "", old_title = "";
                std::cout << "Please enter the title of the note you wish to modify: ";
                std::cin >> old_title;

                // check if the note exists, if not back to main menu
                if (findNote(notes, old_title)) {
                    // note was found
                    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n'); // Ignore remaining newline character after reading the note_title
                    std::cout << "Please enter the new title of the note: ";
                    std::cin >> new_title;
                    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n'); // Ignore remaining newline character after reading the note_title

                    // change note's title
                    changeTitle(notes, old_title, new_title);
                }
                else {
                    std::cin.get();
                }
                clearConsole();
            }

            // change content of the note
            if (value_modify == 2) {
                displayTitles(notes);

                // get the note's title
                std::string title = "", new_content = "";
                std::cout << "Please enter the title of the note you wish to modify: ";
                std::cin >> title;

                // verify if the note with specified title exits
                if (findNote(notes, title)) {
                    // note was found
                    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n'); // Ignore remaining newline character after reading the note_title
                    std::cout << "Content of your note (enter '!ENDNOTE!' on a separate line to finish):\n";

                    // get the new content of the note
                    new_content = "";
                    std::string line;
                    while (std::getline(std::cin, line)) {
                        if (line == "!ENDNOTE!")
                            break;
                        new_content += line + "\n";
                    }

                    // change note's content
                    changeContent(notes, title, new_content);
                }
                else {
                    std::cin.get();
                }
                clearConsole();
            } 

            // remove the note
            if (value_modify == 3) {
                displayTitles(notes);

                std::string title;
                std::cout << "Please input the title of the note to delete: ";
                std::cin >> title;

                if (findNote(notes, title)) {
                    deleteNote(notes, title);
                }
                std::cin.get();
                clearConsole();
            }
            
            // back to main menu 
            if (value_modify == 4) {
                continue;
            }
        }

        // end program
        if (user_choice == 4) {
            end_program = true;
        }
    }

    exportNotes(notes);
    return 0;
}